package ex03;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
	public class ReaperThread extends Thread {
		public void run() {
			while (true) {
				try {
					Reference<?> ref = queue.remove();
					Resource res = null;
					synchronized(ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				} catch (InterruptedException ex) {
					break;
				} 
			}
		}
	}


	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();
	
	}
	
	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			reaper.interrupt();
		}
	}
	
	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}
	
	public static class ResourceImpl implements Resource {
		WeakReference<Object> keyRef;
		boolean needRelease = false;
		
		ResourceImpl(Object key) {
			keyRef = new WeakReference<Object>(key);
			
			needRelease = true;
		}
		
		@Override
		public void use(Object key, Object... args) {
			if (keyRef.get().equals(key))
				throw new IllegalArgumentException("wrong key");

		}
		
		@Override
		public void release() {
			if (needRelease) {
				needRelease = false;
			}
		}

	}

}

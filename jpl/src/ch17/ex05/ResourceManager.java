package ex05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
	
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
	}
	
	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			for (Reference<?> ref: refs.keySet()) {
				Resource res = null;
				synchronized(ResourceManager.this) {
					res = refs.get(ref);
					refs.remove(ref);
				}
				res.release();
				ref.clear();;
			}			
		}
	}
	
	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		reap();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}
	
	public void reap() {
		Reference<?> ref = queue.poll();
		while (ref != null) {
			Resource res = null;
			synchronized(ResourceManager.this) {
				res = refs.get(ref);
				refs.remove(ref);
			}
			res.release();
			refs.remove(ref);
			ref = queue.poll();
		}
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


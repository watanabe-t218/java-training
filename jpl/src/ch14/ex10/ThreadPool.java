/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 * Copyright (C) 2019 Yoshiki Shibata. All rights reserved.
 */

package ex10;

/**

 * Simple Thread Pool class.

 *

 * This class can be used to dispatch an Runnable object to

 * be exectued by a thread.<br><br>

 *

 * [Instruction]

 * <ul>

 *  <li> Implement one constructor and three methods. </li>

 *  <li> Don't forget to write a Test program to test this class. </li>

 *  <li> Pay attention to @throws tags in the javadoc. </li>

 *  <li> If needed, you can put "synchronized" keyword to methods. </li>

 *  <li> All classes for implementation must be private inside this class. </li>

 *  <li> Don't use java.util.concurrent package. </li>

 *  <li> Don't use {@link java.lang.Thread#interrupt}  method to stop a thread</li>

 *  </ul>

 *

 *  @author Yoshiki Shibata

 */

import java.util.LinkedList;

public class ThreadPool {

	private static final Object LOCK = new Object();
	
	private Queue queue;
	private Threads[] threads;
	private boolean isStarted = false;

    public ThreadPool(int queueSize, int numberOfThreads) {
    	if (queueSize < 1) {
    		throw new IllegalArgumentException("queueSize must be [> 1]");
    	}
    	if (numberOfThreads < 1) {
    		throw new IllegalArgumentException("numberOfThreads must be [> 1]");
    	}
    	queue = new Queue(queueSize);
    	threads = new Threads[numberOfThreads];
    	for (int i = 0; i < numberOfThreads; i++) {
    		threads[i] = new Threads();
    	}
    }

    
    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
    	synchronized (LOCK) {
    		if (isStarted) {
    			throw new IllegalStateException("Already Started!!");    		
    		}
    		for (Threads t: threads) {
    			t.start();
    		}
    		isStarted = true;			
		}
    }
    
    /**
     * Stop all threads gracefully and wait for their terminations.
	 * All requests dispatched before this method is invoked must complete
	 * and this method also will wait for their completion.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public synchronized void stop() {
    	if (!isStarted)
    		throw new IllegalStateException("No threads Started!!");
    	isStarted = false;
    	for (Threads t: threads) {
			t.stopThread();
			try {
				t.join();
			} catch (InterruptedException e) {
			}
    	}
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
       	if (runnable == null)
       		throw new NullPointerException("runnable is null");
       	if (!isStarted)
       		throw new IllegalStateException("this pool has not been started yet");
    	queue.add(runnable);
    }

    private class Threads extends Thread {
    	private boolean isStop;

    	Threads() {
    		isStop = false;
    	}

    	public void stopThread() {
    		isStop = true;
    		queue.stop();
		}

		public void run() {
    		while (!isStop) {
    			Runnable r = queue.poll();
    			if ( r != null)
    				r.run();
    		}
    	}


    }

    private static class Queue {
    	private final int queueSize;
    	private LinkedList<Runnable> queue;

    	Queue(int queueSize) {
    		this.queueSize = queueSize;
    		queue = new LinkedList<Runnable>();
    	}

        synchronized boolean add(Runnable r) {
    		while (queue.size() >= queueSize) {
    			try {
					wait();
				} catch (InterruptedException e) {
					return false;
				}
    		}
    		boolean result = queue.add(r);
    		notifyAll();
    		return result;
    	}

    	synchronized Runnable poll() {
    		if (queue.isEmpty()) {
    			try {
					wait();
				} catch (InterruptedException e) {
					return null;
				}
    		}
    		Runnable r = queue.poll();
    		notifyAll();
    		return r;
    	}

    	synchronized void stop() {
    		notifyAll();
    	}
    }
}

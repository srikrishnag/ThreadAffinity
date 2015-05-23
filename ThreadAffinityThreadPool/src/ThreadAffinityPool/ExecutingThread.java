package ThreadAffinityPool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Executing thread of the thread pool, thread pile up the job requests into to be executed in long polling fashion.
 * Here queue is non shared resource as each thread has its own jobs to be executed
 * TODO: Here we have implemented bounded buffer algorithm possible of OOM, in general there should be limitation on
 * the buffer size to avoid such issues.
 * @author krishna
 *
 */
class ExecutingThread implements Runnable{

	private Queue<Runnable> queue;
	private boolean stop;

	public Queue<Runnable> getQueue() {
		return queue;
	}
	public void setQueue(Queue<Runnable> queue) {
		this.queue = queue;
	}
	public ExecutingThread(){
		queue = new LinkedList<Runnable>();
	}

	@Override
	public void run() {
		while(!stop){
			if(queue.isEmpty()){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
				continue;
			}
			else{
				queue.remove().run();							
			}
		}

	}
	
	public void stopGracefully(){
		stop = true;
	}

}
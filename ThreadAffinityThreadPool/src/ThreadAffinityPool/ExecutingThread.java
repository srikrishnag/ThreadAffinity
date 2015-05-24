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
public class ExecutingThread implements Runnable{

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
			doExecution();
		}
	}

	public void doExecution(){
		if(queue.isEmpty()){
			System.out.print("Job queue is empty");
			  try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			queue.remove().run();	
			System.out.print("Removed job from queue");
		}
	}

	public void stopGracefully(){
		stop = true;
		System.out.print("Stopping thread");
	}

}
package ThreadAffinityPool;

/**
 * ClientThread used in threadpool
 * @author krishna
 *
 */
class ClientThread1 implements Runnable{
	@Override
	public void run() {
		String threadId = Thread.currentThread().getName();
		System.out.println("");
		System.out.println("Executing thread: "+threadId);
	}
}

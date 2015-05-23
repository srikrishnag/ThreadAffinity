package ThreadAffinityPool;

/**
 * ClientThread used in threadpool
 * @author krishna
 *
 */
class ClientThread2 implements Runnable{
	@Override
	public void run() {
		String threadId = Thread.currentThread().getName();
		System.out.println(threadId);
	}
}
package ThreadAffinityPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Client program for running the ThreadPoolWithJobAffinity application with different client threads.
 * @author krishna
 *
 */
public class MainThreadPoolTest {

	public static void main(String[] args) {

		ThreadPoolWithJobAffinity threadPool = new  ThreadPoolWithJobAffinityImpl(2);

		ClientThread1 thread1 = new ClientThread1();
		threadPool.submit("1", thread1);

		ClientThread2 thread2 = new ClientThread2();
		threadPool.submit("2", thread2);

		ClientThread1 thread11 = new ClientThread1();
		threadPool.submit("1", thread11);

		ClientThread2 thread22 = new ClientThread2();
		threadPool.submit("2", thread22);

		//ClientThread2 thread23 = new ClientThread2();
		//threadPool.submit("3", thread22);
		
		//threadPool.shutdown();

	}

}

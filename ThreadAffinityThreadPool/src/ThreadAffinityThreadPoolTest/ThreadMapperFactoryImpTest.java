package ThreadAffinityThreadPoolTest;

import static org.junit.Assert.*;
import ThreadAffinityPool.*;

import org.junit.Test;

public class ThreadMapperFactoryImpTest {

	@Test
	public void testGetThreadHappyScenario() throws ThreadException {

		ExecutingThread threads[] = new ExecutingThread[1];	

		threads[0] = new ExecutingThread();

		ThreadMapperFactoryImp thread = new ThreadMapperFactoryImp(threads);

		ExecutingThread t = thread.getThread("job1");
		assertNotNull(t);

	}

	@Test
	public void testGetThreadExistingJobScenario() throws ThreadException {

		ExecutingThread threads[] = new ExecutingThread[1];	

		threads[0] = new ExecutingThread();

		ThreadMapperFactoryImp thread = new ThreadMapperFactoryImp(threads);

		ExecutingThread t1 = thread.getThread("job1");
		ExecutingThread t = thread.getThread("job1");

		assertEquals(t1,t);

	}

	@Test(expected =ThreadException.class)
	public void testGetThreadWithException() throws ThreadException {

		ExecutingThread threads[] = new ExecutingThread[1];	

		threads[0] = new ExecutingThread();

		ThreadMapperFactoryImp thread = new ThreadMapperFactoryImp(threads);

		ExecutingThread t = thread.getThread("job1");
		t = thread.getThread("job2");	

	}


}

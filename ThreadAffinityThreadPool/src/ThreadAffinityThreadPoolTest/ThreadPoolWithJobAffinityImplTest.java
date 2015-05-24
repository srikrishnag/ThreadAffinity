package ThreadAffinityThreadPoolTest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ThreadAffinityPool.ThreadPoolWithJobAffinityImpl;

public class ThreadPoolWithJobAffinityImplTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));	   
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);	 
	}

	@Test(timeout = 100)
	public void testSubmit() {
		ThreadPoolWithJobAffinityImpl t = new ThreadPoolWithJobAffinityImpl(1);
		Runnable runnable1 = new Runnable() {
            @Override public void run() {            
            }
        };
        t.submit("test", runnable1);
        assertEquals("Job queue is emptySubmitted job test to thread pool", outContent.toString());
        t.shutdown();
	}

	@Test(timeout = 100)
	public void testShutdown() {
		ThreadPoolWithJobAffinityImpl t = new ThreadPoolWithJobAffinityImpl(1);
		assertEquals("Job queue is empty", outContent.toString());
		t.shutdown();		
	}

}

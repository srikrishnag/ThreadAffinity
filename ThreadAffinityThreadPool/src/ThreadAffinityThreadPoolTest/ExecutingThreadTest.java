package ThreadAffinityThreadPoolTest;

import static org.junit.Assert.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ThreadAffinityPool.ExecutingThread;

public class ExecutingThreadTest {

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
	public void testRunWithEmptyQueue() {	    
		ExecutingThread t = new ExecutingThread();
		t.doExecution();	
		assertEquals("Job queue is empty", outContent.toString());
		t.stopGracefully();
	}
	
	@Test(timeout = 100)
	public void testRunWithNonEmptyQueue() {	    
		ExecutingThread t = new ExecutingThread();
		Runnable runnable1 = new Runnable() {
            @Override public void run() {            
            }
        };
		t.getQueue().add(runnable1);
		t.doExecution();
		assertEquals("Removed job from queue", outContent.toString());
	    t.stopGracefully();
	}

}

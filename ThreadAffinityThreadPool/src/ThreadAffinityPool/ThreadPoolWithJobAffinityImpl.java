package ThreadAffinityPool;

/**
 * Implementation of ThreadPoolWithJobAffinity
 * @author krishna
 *
 */
public class ThreadPoolWithJobAffinityImpl implements ThreadPoolWithJobAffinity{

	ExecutingThread threadpool[];	
	ThreadMapperFactory threadPoolFactory;
	int poolsize;

	public ThreadPoolWithJobAffinityImpl(int poolSize){

		threadpool = new ExecutingThread[poolSize];

		for(int i=0;i<poolSize;i++){

			threadpool[i] = new ExecutingThread();			
			new Thread(threadpool[i]).start();	
		}

		threadPoolFactory = new ThreadMapperFactoryImp(threadpool);

	}	
	
	public int poolSize(){
		return poolsize;
	}

	public void submit(String jobId, Runnable r){
		try {
			ExecutingThread thread = threadPoolFactory.getThread(jobId);				
			thread.getQueue().add(r);
			System.out.print("Submitted job "+jobId+" to thread pool");
		} catch (ThreadException e) {		
			e.printStackTrace();
		}
	}
	
	public void shutdown(){
		for(int i=0;i<threadpool.length;i++){
			threadpool[i].stopGracefully();
		}
	}

}
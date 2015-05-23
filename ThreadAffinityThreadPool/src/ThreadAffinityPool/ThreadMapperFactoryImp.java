package ThreadAffinityPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of ThreadMapperFactory, in this scenario unique mapping between thread and job 
 * maintained in a hashmap.
 * @author krishna
 *
 */
class ThreadMapperFactoryImp implements ThreadMapperFactory{

	ExecutingThread[] threads;
	int currentThread;
	Map<String,Integer> threadMap;

	public ThreadMapperFactoryImp(ExecutingThread[] threads){
		threadMap = new HashMap<String,Integer>();
		this.threads =  threads;
		currentThread=0;
	}

	public ExecutingThread getThread(String jobId) throws ThreadException{
		
		if(threadMap.containsKey(jobId)){
			return threads[threadMap.get(jobId)];
		}
		
		else{
			if(currentThread>=threads.length){
				throw new ThreadException("Number of jobs "+currentThread+" are more than pool size: " +
						""+threads.length);
			}

			int tmp = currentThread;
			threadMap.put(jobId, currentThread);
			currentThread++;
			return threads[tmp];
		}
	}

}
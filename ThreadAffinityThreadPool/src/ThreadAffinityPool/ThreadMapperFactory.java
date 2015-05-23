package ThreadAffinityPool;

/**
 * Factory handling mapping between jobs and threads
 * @author krishna
 *
 */
interface ThreadMapperFactory{
	/**
	 * Returns thread based on jobId
	 * @param jobId
	 * @return
	 * @throws ThreadException
	 */
	ExecutingThread getThread(String jobId) throws ThreadException;
}
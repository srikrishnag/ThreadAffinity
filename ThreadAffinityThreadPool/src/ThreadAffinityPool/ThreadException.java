package ThreadAffinityPool;

/**
 * User defined exception class for this application
 * @author krishna
 *
 */
public class ThreadException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String str1;
	ThreadException(String str2) {
		str1=str2;
	}
	public String toString(){ 
		return ("Found exception = "+str1) ;
	}
}


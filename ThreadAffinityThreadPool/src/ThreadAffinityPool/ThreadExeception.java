package ThreadAffinityPool;

/**
 * User defined exception class for this application
 * @author krishna
 *
 */
class ThreadException extends Exception{
	String str1;
	ThreadException(String str2) {
		str1=str2;
	}
	public String toString(){ 
		return ("Found exception = "+str1) ;
	}
}


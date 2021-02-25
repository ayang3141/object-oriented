/**
 * 
 * @author Adam Yang
 * 
 * Exception for no temperature readings.
 */
public class NoTempReadingForMonthException extends Exception {
	private String msg;
	
	public NoTempReadingForMonthException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}

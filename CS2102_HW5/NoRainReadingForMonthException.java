/**
 * 
 * @author Adam Yang
 * 
 * Exception for no rainfall readings.
 */
public class NoRainReadingForMonthException extends Exception {
	private String msg;
	
	public NoRainReadingForMonthException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
	}
	
}

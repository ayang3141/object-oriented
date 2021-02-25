/**
 * 
 * @author Adam Yang
 *
 * Particular hour and minute of a day.
 */
public class Time {

	private int hour;
	private int minute;
	
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	// getter method for the hour
	public int getHour() {
		return this.hour;
	}
	
	// getter method for the minute
	public int getMinute() {
		return this.minute;
	}
	
}

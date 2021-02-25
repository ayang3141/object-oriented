
/**
 * 
 * @author Adam Yang
 *
 * Weather reading for a given time.
 */
public class Reading {
	
	private Time time;
	private double temp;
	private double rainfall;
	
	public Reading(Time time, double temp, double rainfall) {
		this.time = time;
		this.temp = temp;
		this.rainfall = rainfall;
	}
	
	// getter method for temperature reading
	public double getTemp() {
		return this.temp;
	}
	
	// getter method for rainfall reading
	public double getRain() {
		return this.rainfall;
	}
	
	
	
}

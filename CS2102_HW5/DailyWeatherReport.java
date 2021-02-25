
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 * 
 * @author Adam Yang
 * 
 * Weather report for a given day.
 */
public class DailyWeatherReport {

	
	private GregorianCalendar date; 
	private LinkedList<Double> tempReadings = new LinkedList<Double>();
	private LinkedList<Double> rainfallReadings = new LinkedList<Double>();
	
	
	public DailyWeatherReport(GregorianCalendar date, LinkedList<Double> tempReadings, LinkedList<Double> rainfallReadings) {
		this.date = date;
		this.tempReadings = tempReadings;
		this.rainfallReadings = rainfallReadings;
	}
	
	/**
	 * Checks if date of weather report matches given month and year.
	 * @param month, desired month.
	 * @param year, desired year.
	 * @return true if month and year matches that of the weather report.
	 */
	public boolean checkMonth(int month, int year) {
		return this.date.get(GregorianCalendar.MONTH) + 1 == month && this.date.get(GregorianCalendar.YEAR) == year;
	}
	
	/**
	 * Sums the temperature readings for the weather report.
	 * @return total temperature.
	 */
	public double sumTemps() {
		double sum = 0;
		for(Double currentTemp : this.tempReadings) {
			sum += currentTemp;

		}

		return sum;
	}
	
	/**
	 * Counts the number of temperature readings for the weather report.
	 * @return number of temperature readings.
	 * @throws NoTempReadingForMonthException, error due to no temperature readings.
	 */
	public int countTemps() throws NoTempReadingForMonthException {
		int count = 0;
		for(Double currentTemp : this.tempReadings) {
			count++;

		}
		
		if(count == 0) {
			throw new NoTempReadingForMonthException("Report has no temperature readings!");
		}

		return count;
	}
	
	/**
	 * Sums the rainfall readings for the weather report.
	 * @return total rainfall.
	 */
	public double sumRainfall() {
		double sum = 0;
		for(Double currentRain : this.rainfallReadings) {
			sum += currentRain;
		}
		
		return sum;
	}
	
	/**
	 * Counts the number of rainfall readings in the weather report.
	 * @return number of rainfall readings.
	 * @throws NoRainReadingForMonthException, error due o no rainfall readings.
	 */
	public int countRainfall() throws NoRainReadingForMonthException {
		int count = 0;
		for(Double currentRain : this.rainfallReadings) {
			count++;
		}
		
		if(count == 0) {
			throw new NoRainReadingForMonthException("Report has no rain readings!");
		}
		
		return count;
	}
	
}

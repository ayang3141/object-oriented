import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 * 
 * @author Adam Yang
 *
 *
 * Monitors and tracks weather patterns.
 */
public class WeatherMonitor {
	private IWeatherReportDS weatherReports;
	
	
	
	public WeatherMonitor(IWeatherReportDS weatherReports) {
		this.weatherReports = weatherReports;
	}
	
	/**
	 * Determines the average temperature in a particular month of a year.
	 * @param month, desired month.
	 * @param year, desired year.
	 * @return average temperature of the month.
	 * @throws NoTempReadingForMonthException, error due to no available temperature readings for desire month.
	 */
	public double averageTempForMonth(int month, int year) throws NoTempReadingForMonthException {
		double avgTemp = 0;
		if(weatherReports.checkMonthForData(month, year)) {
//			try {
			avgTemp = weatherReports.findAvgTempOfMonth(month, year);	// could throw no reading exception
//			}
//			catch(NoTempReadingForMonthException error) {
//				System.out.println("Error: " + error.getMessage());
//			}
		}
		else {
			throw new NoTempReadingForMonthException("No temperature readings for this month!");
		}

		return avgTemp;
	}
	
	
	/**
	 * Determines the total rainfall for a particular month of a year.
	 * @param month, desired month.
	 * @param year, desired year.
	 * @return total rainfall of the month.
	 * @throws NoRainReadingForMonthException, error due to no available rainfall readings for desired month.
	 */
	public double totalRainfallForMonth(int month, int year) throws NoRainReadingForMonthException {
		double totalRain = 0;
		
		if(weatherReports.checkMonthForData(month, year)) {
//			try {
			totalRain = weatherReports.findTotalRainfallOfMonth(month, year);	// could throw no reading exception			
//			}
//			catch(NoRainReadingForMonthException error) {
//				System.out.println("Error: " + error.getMessage());
//			}
		}
		else {
			throw new NoRainReadingForMonthException("No rain readings for this month!");
		}
				
		return totalRain;
	}
	
	
	/**
	 * Adds new weather report.
	 * @param date, date of the new weather report.
	 * @param readings, list of weather readings for the day.
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		weatherReports.addNewReport(date, readings);
	}
	
	
}

import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 * 
 * @author Adam Yang
 * 
 * LinkedList of Daily Weather Reports
 */
public class DailyWeatherReportLL implements IWeatherReportDS {
	private LinkedList<DailyWeatherReport> weatherReports = new LinkedList<DailyWeatherReport>();
	
	/**
	 * Checks if a given month has available readings.
	 * @param month, desired month.
	 * @param year, desired year.
	 * @return true if given month has any readings.
	 */
	public boolean checkMonthForData(int month, int year) {
		for(DailyWeatherReport currentReport : weatherReports) {
			if(currentReport.checkMonth(month, year)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Calculates the average temperature in a given month and year.
	 * @param month, desired month.
	 * @param year, desired year.
	 * @return average temperature of month.
	 * @throws NoTempReadingForMonthException, error due to no available temperature readings for the month.
	 */
	public double findAvgTempOfMonth(int month, int year) throws NoTempReadingForMonthException {
		double sum = 0;
		int count = 0;
		for(DailyWeatherReport currentReport : weatherReports) {
			if(currentReport.checkMonth(month, year)) {
				sum += currentReport.sumTemps();
				count += currentReport.countTemps();	// could throw no temp exception
				
			}
		}

		return sum/count;
	}
	
	
	/**
	 * Calculates the total rainfall in a given month and year.
	 * @param month, desired month.
	 * @param year, desired year.
	 * @return total rainfall of month.
	 * @throws NoRainReadingForMonthException, error due to no available rain readings for the month.
	 * 
	 */
	public double findTotalRainfallOfMonth(int month, int year) throws NoRainReadingForMonthException {
		double sum = 0;
		for(DailyWeatherReport currentReport : weatherReports) {
			if(currentReport.checkMonth(month, year)) {
				sum += currentReport.sumRainfall();
				currentReport.countRainfall();	// could throw no rain exception
			}
		}
		
		return sum;
	}
	
	/**
	 * Adds new weather report.
	 * @param date, date of the new weather report.
	 * @param readings, weather readings of the day.
	 */
	public void addNewReport(GregorianCalendar date, LinkedList<Reading> readings) {
		LinkedList<Double> tempList = new LinkedList<Double>();
		LinkedList<Double> rainList = new LinkedList<Double>();

		for(Reading currentReading : readings) {
			rainList.add(currentReading.getRain());
			tempList.add(currentReading.getTemp());
		}
		
		
		weatherReports.add(new DailyWeatherReport(date, tempList, rainList));
	}
}

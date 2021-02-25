import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * 
 * @author Adam Yang
 * 
 * Interface for weather monitor
 */
public interface IWeatherReportDS {
	public boolean checkMonthForData(int month, int year);
	
	public double findAvgTempOfMonth(int month, int year) throws NoTempReadingForMonthException;
	
	public double findTotalRainfallOfMonth(int month, int year) throws NoRainReadingForMonthException;
	
	public void addNewReport(GregorianCalendar date, LinkedList<Reading> readings);
}

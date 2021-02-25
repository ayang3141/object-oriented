import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;
import java.util.GregorianCalendar;

public class Examples {
	IWeatherReportDS weatherReport = new DailyWeatherReportLL();
	
	WeatherMonitor weatherMonitor = new WeatherMonitor(weatherReport);
	
	Time currentTime = new Time(10, 28);
	
	LinkedList<Reading> readingList1 = new LinkedList<Reading>();	// low readings
	LinkedList<Reading> readingList2 = new LinkedList<Reading>();
	LinkedList<Reading> readingList3 = new LinkedList<Reading>();
	LinkedList<Reading> readingList4 = new LinkedList<Reading>();
	LinkedList<Reading> readingList5 = new LinkedList<Reading>();	// empty list
	LinkedList<Reading> readingList6 = new LinkedList<Reading>();	// negative readings
	

	// Positive Readings
	Reading reading1 = new Reading(currentTime, 10.0, 1.0);
	Reading reading2 = new Reading(currentTime, 20.0, 2.0);
	Reading reading3 = new Reading(currentTime, 30.0, 3.0);
	Reading reading4 = new Reading(currentTime, 40.0, 4.0);
	Reading reading5 = new Reading(currentTime, 50.0, 5.0);
	Reading reading6 = new Reading(currentTime, 60.0, 6.0);
	Reading reading7 = new Reading(currentTime, 70.0, 7.0);
	Reading reading8 = new Reading(currentTime, 80.0, 8.0);
	Reading reading9 = new Reading(currentTime, 90.0, 9.0);
	Reading reading10 = new Reading(currentTime, 100.0, 10.0);
	
	// Negative Readings
	Reading reading11 = new Reading(currentTime, -50.0, -10.0);
	Reading reading12 = new Reading(currentTime, -20.0, -20.0);
	Reading reading13 = new Reading(currentTime, -80.0, -15.0);
	
	GregorianCalendar date1 = new GregorianCalendar(2019, 2, 1);
	GregorianCalendar date2 = new GregorianCalendar(2019, 2, 2);
	GregorianCalendar date3 = new GregorianCalendar(2019, 2, 3);
	GregorianCalendar date4 = new GregorianCalendar(2019, 3, 4);
	GregorianCalendar date5 = new GregorianCalendar(2019, 3, 5);
	GregorianCalendar date6 = new GregorianCalendar(2019, 3, 6);
	GregorianCalendar date7 = new GregorianCalendar(2020, 2, 1);
	GregorianCalendar date8 = new GregorianCalendar(2020, 2, 2);
	GregorianCalendar date9 = new GregorianCalendar(2020, 2, 3);
	GregorianCalendar date10 = new GregorianCalendar(2020, 3, 4);
	GregorianCalendar date11 = new GregorianCalendar(2020, 3, 5);
	GregorianCalendar date12 = new GregorianCalendar(2020, 3, 6);
	GregorianCalendar date13 = new GregorianCalendar(2020, 11, 6);
	GregorianCalendar date14 = new GregorianCalendar(2020, 10, 6);
	
	
	public Examples() {
		// only low readings
		readingList1.add(reading1);
		readingList1.add(reading1);
		readingList1.add(reading1);
		
		// only high readings
		readingList2.add(reading10);
		readingList2.add(reading10);
		readingList2.add(reading10);
		
		// mixed readings 1
		readingList3.add(reading3);
		readingList3.add(reading7);
		readingList3.add(reading8);
		
		// mixed readings 2
		readingList4.add(reading9);
		readingList4.add(reading4);
		readingList4.add(reading5);
		
		// negative readings
		readingList6.add(reading11);
		readingList6.add(reading12);
		readingList6.add(reading13);
		
		
		
		// March, 2019
		weatherMonitor.addDailyReport(date1, readingList1);
		weatherMonitor.addDailyReport(date2, readingList1);
		weatherMonitor.addDailyReport(date3, readingList1);
		
		// April, 2019
		weatherMonitor.addDailyReport(date4, readingList2);
		weatherMonitor.addDailyReport(date5, readingList2);
		weatherMonitor.addDailyReport(date6, readingList2);
		
		// March, 2020
		weatherMonitor.addDailyReport(date7, readingList3);
		weatherMonitor.addDailyReport(date8, readingList3);
		weatherMonitor.addDailyReport(date9, readingList3);
		
		// April, 2020
		weatherMonitor.addDailyReport(date10, readingList4);
		weatherMonitor.addDailyReport(date11, readingList4);
		weatherMonitor.addDailyReport(date12, readingList4);
		
		// December, 2020
		weatherMonitor.addDailyReport(date13, readingList5);
		
		// November, 2020
		weatherMonitor.addDailyReport(date14, readingList6);
		
		
	}
	
	
	
	// averageTempForMonth
	@Test
	public void testAverageTempForMonthMixedValues() throws NoTempReadingForMonthException {
		assertEquals(60.0, weatherMonitor.averageTempForMonth(3, 2020), 0.001);
	}
	
	@Test
	public void testAverageTempForMonthConstantReadings() throws NoTempReadingForMonthException {
		assertEquals(10.0, weatherMonitor.averageTempForMonth(3, 2019), 0.001);
	}
	
	@Test
	public void testAverageTempForMonthNegativeReadings() throws NoTempReadingForMonthException {
		assertEquals(-50.0, weatherMonitor.averageTempForMonth(11, 2020), 0.001);
	}
	
	@Test
	public void testAverageTempForMonthTempExceptionThrownNoWeatherReport() throws NoTempReadingForMonthException {
		
		try {
			double result = weatherMonitor.averageTempForMonth(6, 2020);
			
		}
		catch(NoTempReadingForMonthException error) {
			assertEquals("No temperature readings for this month!", error.getMessage());
		}
	}
	
	@Test
	public void testAverageTempForMonthTempExceptionThrownNoReadings() throws NoTempReadingForMonthException {
		
		try {
			double result = weatherMonitor.averageTempForMonth(12, 2020);
			
		}
		catch(NoTempReadingForMonthException error) {
			assertEquals("Report has no temperature readings!", error.getMessage());
		}
	}
	
	
	
	
	
	
	// totalRainfallForMonth
	@Test
	public void testTotalRainfallForMonthMixedValues() throws NoRainReadingForMonthException {
		assertEquals(54.0, weatherMonitor.totalRainfallForMonth(4, 2020), 0.001);
	}
	
	@Test
	public void testTotalRainfallForMonthConstantReadings() throws NoRainReadingForMonthException {
		assertEquals(90.0, weatherMonitor.totalRainfallForMonth(4, 2019), 0.001);
	}
	
	@Test
	public void testTotalRainfallForMonthNegativeReadings() throws NoRainReadingForMonthException {
		assertEquals(-45.0, weatherMonitor.totalRainfallForMonth(11, 2020), 0.001);
	}
	
	
	@Test
	public void testTotalRainfallForMonthRainExceptionThrownNoWeatherReport() throws NoRainReadingForMonthException {
		try {
			double result = weatherMonitor.totalRainfallForMonth(5, 2020);
			
		}
		catch(NoRainReadingForMonthException error) {
			
			assertEquals("No rain readings for this month!", error.getMessage());
		}
	}
	
	@Test
	public void testTotalRainfallForMonthRainExceptionThrownNoReadings() throws NoRainReadingForMonthException {
		try {
			double result = weatherMonitor.totalRainfallForMonth(12, 2020);
			
		}
		catch(NoRainReadingForMonthException error) {
			
			assertEquals("Report has no rain readings!", error.getMessage());
		}
	}
	
	
	
	
	
	
	

}

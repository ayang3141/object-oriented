import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  
  // All matching months
  LinkedList<Double> threeDates2 = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports2 = new LinkedList<MaxHzReport>();
  
  // Mixed months
  LinkedList<Double> threeDates3 = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports3 = new LinkedList<MaxHzReport>();
  
  // No matching months
  LinkedList<Double> threeDates4 = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports4 = new LinkedList<MaxHzReport>();
  
  // empty list
  LinkedList<Double> threeDates5 = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports5 = new LinkedList<MaxHzReport>();
  
  // only negative readings
  LinkedList<Double> threeDates6 = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports6 = new LinkedList<MaxHzReport>();
  
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    threeDates.add(20151102.0);
    threeDates.add(-0.03);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    
    threeDates2.add(20151101.0);
    threeDates2.add(6.0);
    threeDates2.add(20151102.0);
    threeDates2.add(0.01);
    threeDates2.add(0.02);
    threeDates2.add(-0.03);
    NovReports2.add(new MaxHzReport(20151101.0, 6.0));
    NovReports2.add(new MaxHzReport(20151102.0, 0.02));
    
    threeDates3.add(20151013.0);
    threeDates3.add(10.0);
    threeDates3.add(5.0);
    threeDates3.add(20151020.0);
    threeDates3.add(40.0);
    threeDates3.add(50.0);
    threeDates3.add(45.0);
    threeDates3.add(20151101.0);
    threeDates3.add(6.0);
    threeDates3.add(20151102.0);
    threeDates3.add(0.01);
    threeDates3.add(0.02);
    threeDates3.add(-0.03);
    threeDates3.add(20151211.0);
    threeDates3.add(12.1);
    threeDates3.add(12.2);
    NovReports3.add(new MaxHzReport(20151101.0, 6.0));
    NovReports3.add(new MaxHzReport(20151102.0, 0.02));
    
    threeDates4.add(20151013.0);
    threeDates4.add(10.0);
    threeDates4.add(5.0);
    threeDates4.add(20151020.0);
    threeDates4.add(40.0);
    threeDates4.add(50.0);
    threeDates4.add(45.0);
    threeDates4.add(20150701.0);
    threeDates4.add(6.0);
    threeDates4.add(20150702.0);
    threeDates4.add(0.01);
    threeDates4.add(0.02);
    threeDates4.add(-0.03);
    threeDates4.add(20151211.0);
    threeDates4.add(12.1);
    threeDates4.add(12.2);
    
    
    threeDates6.add(20151013.0);
    threeDates6.add(-10.0);
    threeDates6.add(-5.0);
    threeDates6.add(20151020.0);
    threeDates6.add(-40.0);
    threeDates6.add(-50.0);
    threeDates6.add(-45.0);
    threeDates6.add(20151101.0);
    threeDates6.add(-6.0);
    threeDates6.add(20151102.0);
    threeDates6.add(-0.03);
    
    

    
    
  }
  
  @Test
  public void testEarthquakeMixedMonths() {
	  assertEquals(NovReports3, E1.dailyMaxForMonth(threeDates3, 11));
  }

  @Test
  public void instructorTestEQ() { 
	  assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
  }
  
  @Test
  public void testEarthquakeAllMatchingMonths() {
	  assertEquals(NovReports2, E1.dailyMaxForMonth(threeDates2, 11));
  }
  
  
  @Test
  public void testEarthquakeNoMatchingMonth() {
	  assertEquals(NovReports4, E1.dailyMaxForMonth(threeDates4, 11));
  }
  
  @Test
  public void testEarthquakeEmptyList() {
	  assertEquals(NovReports5, E1.dailyMaxForMonth(threeDates5, 11));
  }
  
  @Test
  public void testEarthquakeOnlyNegativeValues() {
	  assertEquals(NovReports6, E1.dailyMaxForMonth(threeDates6, 11));
  }
  
  /**
   * Subtasks for Earthquake:
   * find max reading, ignoring negative readings, ignoring dates without matching month, parsing until different date
   * 
   */

}

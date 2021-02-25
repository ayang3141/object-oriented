import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples 
{  
  LinkedList<Show> shows = new LinkedList<Show>();
  LinkedList<Double> showResults = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  
  // All zero
  LinkedList<Show> shows2 = new LinkedList<Show>();
  LinkedList<Double> showResults2 = new LinkedList<Double>();
  
  // All constant
  LinkedList<Show> shows3 = new LinkedList<Show>();
  LinkedList<Double> showResults3 = new LinkedList<Double>();
  
  // Mixed Values
  LinkedList<Show> shows4 = new LinkedList<Show>();
  LinkedList<Double> showResults4 = new LinkedList<Double>();
  
  public DataSmoothExamples() 
  {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1, false));
		shows4.add(new Show("Star Trek", 1800, eps1, false));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2, false));
		shows4.add(new Show("Futurama", 1900, eps2, false));
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3, false));
		shows4.add(new Show("Animaniacs", 1630, eps3, false));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4, false));
		shows4.add(new Show("Sesame Street", 900, eps4, false));
		
		LinkedList<Episode> eps5 = new LinkedList<Episode>();
		eps5.add(new Episode("WPI", 0));
		eps5.add(new Episode("beats", 0));
		eps5.add(new Episode("MIT", 0));
		shows2.add(new Show("WPI is better", 900, eps5, false));
		shows2.add(new Show("WPI is better", 900, eps5, false));
		shows2.add(new Show("WPI is better", 900, eps5, false));
		shows2.add(new Show("WPI is better", 900, eps5, false));
		shows2.add(new Show("WPI is better", 900, eps5, false));
		
		shows4.add(new Show("WPI is better", 900, eps5, false));
		
		LinkedList<Episode> eps6 = new LinkedList<Episode>();
		eps6.add(new Episode("I", 12));
		eps6.add(new Episode("Am", 12));
		eps6.add(new Episode("Happy", 12));
		shows3.add(new Show("Are You Happy?", 900, eps6, false));
		shows3.add(new Show("Are You Happy?", 900, eps6, false));
		shows3.add(new Show("Are You Happy?", 900, eps6, false));
		shows3.add(new Show("Are You Happy?", 900, eps6, false));
		shows3.add(new Show("Are You Happy?", 900, eps6, false));
		
		shows4.add(new Show("Are You Happy?", 900, eps6, false));
		

		
		
	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);
	    
	    showResults2.add(0.0);
	    showResults2.add(0.0);
	    showResults2.add(0.0);
	    showResults2.add(0.0);
	    showResults2.add(0.0);
	    
	    showResults3.add(12.0);
	    showResults3.add(12.0);
	    showResults3.add(12.0);
	    showResults3.add(12.0);
	    showResults3.add(12.0);
	    
	    showResults4.add(60.0);
	    showResults4.add(29.75);
	    showResults4.add(29.08333);
	    showResults4.add(21.66666);
	    showResults4.add(23.33333);
	    showResults4.add(12.0);
	    
  }
  
  @Test
  public void instructorTestDS() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }
  
  @Test
  public void testDataSmoothAllZeros() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows2);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults2.get(i), .01);
	  }
  }
  
  @Test
  public void testDataSmoothAllConstant() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows3);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults3.get(i), .01);
	  }
  }
  
  @Test
  public void testDataSmoothMixedValues() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows4);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults4.get(i), .01);
	  }
  }
  
  /**
   * Subtasks for Data Smoothing:
   * summing elements, counting elements, calculating averages, calculating smoothed average
   * 
   */
  
}
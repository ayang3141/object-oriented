import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples
{
	ShowManager1 sm1 = new ShowManager1();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	
	// Only desired show time, no specials
	LinkedList<Show> showsA = new LinkedList<Show>();	
	ShowSummary reportA = new ShowSummary();
	
	// only desired show times, with specials
	LinkedList<Show> showsB = new LinkedList<Show>();	
	ShowSummary reportB = new ShowSummary();
	
	// with overnight, no specials
	LinkedList<Show> showsC = new LinkedList<Show>();	
	ShowSummary reportC = new ShowSummary();
	
	// with overnight, with specials
	LinkedList<Show> showsD = new LinkedList<Show>();	
	ShowSummary reportD = new ShowSummary();
	
	public ShowExamples()
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1, false);	// primetime
		shows.add(s1);
		report1.primetime.add(s1);
		
		showsA.add(s1);
		reportA.primetime.add(s1);
		
		showsB.add(s1);
		
		showsC.add(s1);
		
		showsD.add(s1);
		
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2, false);	// primetime
		shows.add(s2);
		report1.primetime.add(s2);
		
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3, false); // daytime
		shows.add(s3);
		report1.daytime.add(s3);
		
		showsA.add(s3);
		reportA.daytime.add(s3);
		
		showsB.add(s3);
		
		showsC.add(s3);
		
		showsD.add(s3);
		
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4, false);	// daytime
		shows.add(s4);
		report1.daytime.add(s4);
		
		
		LinkedList<Episode> eps5 = new LinkedList<Episode>();
		eps5.add(new Episode("The Letter M", 100));
		eps5.add(new Episode("The Letter I", 100));
		eps5.add(new Episode("The Letter T", 100));
		Show s5 = new Show("MIT", 2300, eps5, false);		// latenight
		shows.add(s5);
		report1.latenight.add(s5);
		
		showsA.add(s5);
		reportA.latenight.add(s5);
		
		showsB.add(s5);
		
		showsC.add(s5);
		
		showsD.add(s5);
		
		
		LinkedList<Episode> eps6 = new LinkedList<Episode>();
		eps5.add(new Episode("Who", 50));
		eps5.add(new Episode("Am", 50));
		eps5.add(new Episode("I", 50));
		Show s6 = new Show("WHO AM I", 500, eps6, false);	// overnight
		
		showsC.add(s6);
		showsD.add(s6);
		
		
		LinkedList<Episode> eps7 = new LinkedList<Episode>();
		eps7.add(new Episode("Best of Both Worlds", 88));
		eps7.add(new Episode("The Ultimate Computer", 49));
		eps7.add(new Episode("Trials and Tribble-ations", 43));		
		Show s7 = new Show("Special Star Trek", 1800, eps7, true);	// special primetime
		
		showsB.add(s7);
		showsD.add(s7);
		
		LinkedList<Episode> eps8 = new LinkedList<Episode>();
		eps8.add(new Episode("Fear of a Bot Planet", 23));
		eps8.add(new Episode("The Why of Fry", 21));
		eps8.add(new Episode("Roswell that Ends Well", 23));
		eps8.add(new Episode("Meanwhile", 22));
		Show s8 = new Show("Special Futurama", 1900, eps8, true);	// special primetime
		
		LinkedList<Episode> eps9 = new LinkedList<Episode>();
		eps9.add(new Episode("Yakko's World", 4));
		eps9.add(new Episode("Hello Nice Warners", 8));
		eps9.add(new Episode("Where Rodents Dare", 9));
		Show s9 = new Show("Special Animaniacs", 1630, eps9, true); // special daytime
		
		showsB.add(s9);
		showsD.add(s9);
		
		LinkedList<Episode> eps10 = new LinkedList<Episode>();
		eps10.add(new Episode("The Letter W", 59));
		eps10.add(new Episode("The Letter P", 57));
		eps10.add(new Episode("The Letter I", 58));
		Show s10 = new Show("Special Sesame Street", 900, eps10, true);	// special daytime
		
		LinkedList<Episode> eps11 = new LinkedList<Episode>();
		eps11.add(new Episode("The Letter M", 100));
		eps11.add(new Episode("The Letter I", 100));
		eps11.add(new Episode("The Letter T", 100));
		Show s11 = new Show("Special MIT", 2300, eps11, true);		// special latenight
		
		showsB.add(s11);
		showsD.add(s11);
		
		LinkedList<Episode> eps12 = new LinkedList<Episode>();
		eps12.add(new Episode("Who", 50));
		eps12.add(new Episode("Am", 50));
		eps12.add(new Episode("I", 50));
		Show s12 = new Show("Special WHO AM I", 500, eps12, true);	// special overnight
		showsD.add(s12);
	}
	
	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	
	@Test
	public void testOnlyDesiredTimesWithoutSpecials()
	{
		ShowSummary reportA1 = sm1.organizeShows(showsA);
		assertEquals(reportA, reportA1);
	}
	
	@Test
	public void testOnlyDesiredTimesWithSpecials()
	{
		ShowSummary reportA1 = sm1.organizeShows(showsB);
		assertEquals(reportA, reportA1);
	}
	
	@Test
	public void testWithLatenightWithoutSpecials()
	{
		ShowSummary reportA1 = sm1.organizeShows(showsC);
		assertEquals(reportA, reportA1);
	}
	
	@Test
	public void testWithLatenightWithSpecials()
	{
		ShowSummary reportA1 = sm1.organizeShows(showsD);
		assertEquals(reportA, reportA1);
	}
	
	
	
	
	/**
	 * Subtasks for ShowManager:
	 * Sort shows, compare broadcast times, ignoring special show times, ignoring overnight shows
	 * 
	 */

}

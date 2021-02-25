import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}

	/**
	 * Sorts shows into daytime, prime time, and late night categories.
	 * @param shows, shows to be sorted.
	 * @return Summary of shows in their respective categories.
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary showReport = new ShowSummary();
		LinkedList<Show> dayList = new LinkedList<Show>();
		LinkedList<Show> primeList = new LinkedList<Show>();
		LinkedList<Show> lateList = new LinkedList<Show>();
		
		for(Show currentShow : shows) {
			// Find all non-special shows with daytime broadcast hours (Between 6:00 AM and 5:00 PM)
			if(currentShow.broadcastTime >= 600 
					&& currentShow.broadcastTime < 1700 
					&& !currentShow.isSpecial) {
				dayList.add(currentShow);	//
			}
		}
		
		for(Show currentShow : shows) {
			// Find all non-special shows with prime time broadcast hours (Between 5:00 PM and 10:00 PM)
			if(currentShow.broadcastTime >= 1700 
					&& currentShow.broadcastTime < 2200 
					&& !currentShow.isSpecial) {
				primeList.add(currentShow);
			}
		}
		
		for(Show currentShow : shows) {
			// Find all non-special shows with late-night broadcast hours (Between 10:00 PM and 1:00 AM)
			if((currentShow.broadcastTime >= 2200 && currentShow.broadcastTime < 2400) 
				|| (currentShow.broadcastTime >= 0 && currentShow.broadcastTime < 100)
				&& !currentShow.isSpecial) {
				lateList.add(currentShow);
			}
		}
		
		showReport.daytime = dayList;
		showReport.primetime = primeList;
		showReport.latenight = lateList;
		
		return showReport;
	}
	
}

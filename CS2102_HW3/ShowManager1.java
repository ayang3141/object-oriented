import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}

	/**
	 * Sorts shows into daytime, prime time, and late night categories.
	 * @param shows, shows to be sorted.
	 * @return Summary of shows in their respective categories.
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary showReport = new ShowSummary();
		for(Show currentShow  : shows) {
			
			if(!currentShow.isSpecial) {	// if show is not special
				double bTime = currentShow.broadcastTime;
				
				if(bTime >= 600 && bTime < 1700) {	// Between 6:00 AM and 5:00 PM (daytime)
					showReport.daytime.add(currentShow);
				}
				else if(bTime >= 1700 && bTime < 2200) {	// Between 5:00 PM and 10:00 PM (prime time)
					showReport.primetime.add(currentShow);
				}
				else if((bTime >= 2200 && bTime < 2400) 
						|| (bTime >= 0 && bTime < 100)) {	// Between 10:00 PM and 1:00 AM (late night)
					showReport.latenight.add(currentShow);	
				}
			}
		}
		
		return showReport;
	}
	
}

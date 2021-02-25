import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}
  
  
  /**
   * Determines the smoothed averages of the show run times.
   * @param shows, shows to be processed
   * @return List of smoothed averages of the show run times.
   */
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> RTimes = new LinkedList<Double>();
	  LinkedList<Double> smoothedRTimes = new LinkedList<Double>();
	  
	  
	  
	  for(Show currentShow : shows) {	// calculate average runtime for each show, no smoothing
		  
		  int numEpisodes = 0;
		  int totalRunTime = 0;
		  for(Episode currentEpisode : currentShow.episodes) {	// sums number of episodes and total run time
			  numEpisodes++;					// counts number of episodes
			  totalRunTime += currentEpisode.runTime;	// sums total episode run times
		  }
		  
		  double currentAvg = (double)totalRunTime / numEpisodes;	// current average run time
		  RTimes.add(currentAvg);
	  }
	  
	  for(int i = 0; i < RTimes.size(); i++) {	// calculates the smoothed runtime values
		  if(!(i == 0 || i == RTimes.size() - 1)) {	// index is not first or last
			  double trio = (RTimes.get(i-1) + RTimes.get(i) + RTimes.get(i+1)) / 3.0;
			  smoothedRTimes.add(trio);
		  }
		  else
		  {
			  smoothedRTimes.add(RTimes.get(i));	// index is first or last
		  }
	  }
	  
	  
	  return smoothedRTimes;
  }
}
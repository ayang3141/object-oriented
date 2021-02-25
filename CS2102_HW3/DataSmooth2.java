import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}
  
  /**
   * Determines the smoothed averages of the show run times.
   * @param shows, shows to be processed
   * @return List of smoothed averages of the show run times.
   */
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  
	  LinkedList<Double> RTimes = new LinkedList<Double>();
	  LinkedList<Double> smoothedRTimes = new LinkedList<Double>();
	  
	  
	  
	  for(int i = 0; i < shows.size(); i++) {	// calculates the smoothed runtime value at current spot
		  
		  if(!(i == 0 || i == shows.size() - 1)) {	// index is not first or last
			  
			  double totalRunTime1 = 0;
			  double totalRunTime2 = 0;
			  double totalRunTime3 = 0;
			  
			  int numEpisodes1 = 0;
			  int numEpisodes2 = 0;
			  int numEpisodes3 = 0;
			  
			  for(Episode currentEpisode : shows.get(i-1).episodes) {	// first show of trio
				  numEpisodes1++;	// count number of episodes
				  totalRunTime1 += currentEpisode.runTime;	// summing total episode run time
			  }
			  
			  for(Episode currentEpisode : shows.get(i).episodes) {	// second show of trio
				  numEpisodes2++;	// count number of episodes
				  totalRunTime2 += currentEpisode.runTime; // summing total episodes run time	
			  }
			  
			  for(Episode currentEpisode : shows.get(i+1).episodes) {	// third show of trio
				  numEpisodes3++;	// count number of episodes
				  totalRunTime3 += currentEpisode.runTime;	// summing total episode run time
			  }
			  
			  // run time averages of each show
			  double avg1 = totalRunTime1/numEpisodes1;
			  double avg2 = totalRunTime2/numEpisodes2;
			  double avg3 = totalRunTime3/numEpisodes3;
			  
			  // current smoothed average
			  smoothedRTimes.add((avg1 + avg2 + avg3)/3.0);
			  
			  
		  }
		  else {									// index is first or last
			  int numEpisodes = 0;
			  double totalRunTime = 0;
			  for(Episode currentEpisode : shows.get(i).episodes) {	// sums number of episodes and run times
				  numEpisodes++;	// count number of episodes 
				  totalRunTime += currentEpisode.runTime;	// summing total episode run time
			  }
			  smoothedRTimes.add(totalRunTime/numEpisodes);
		  }
	  }
	  
	  
	  return smoothedRTimes;
	  

  }
}
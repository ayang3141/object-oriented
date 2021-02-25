import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
  /**
   * Determines daily maximum reading for each day in a given month.
   * @param data, List of double values that represent dates and readings.
   * @param month, Desired month of earthquake reports.
   * @return List of maximum readings for each day in given month
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  
	  LinkedList<MaxHzReport> maxReport = new LinkedList<MaxHzReport>();
	  double currentDailyMax = -1;	//
	  double currentDate = 0.0;
	  
	  /* Sift through loop and record date with matching month
	   * and keep track of highest reading
	   */
	  for(int i = 0; i < data.size(); i++) { 
		 
		  if(i == 0) 					// first element (assumed to be date)
		  {
			  if(extractMonth(data.get(i)) == month) {	// date has matching month
				  currentDate = data.get(i);
			  }
		  }
		  else if(i == data.size() - 1)	// last element (assumed to be reading)
		  {
			  if(currentDailyMax >= 0 ) {	// most recent date has valid reading
				  if(data.get(i) > currentDailyMax) {	// last element is larger than previous readings
					  currentDailyMax = data.get(i);
				  }
				  maxReport.add(new MaxHzReport(currentDate, currentDailyMax));	
			  }
		  }
		  else							// neither first or last element
		  {
			  if(isDate(data.get(i)))	// current number is a date
			  {
				  if(extractMonth(data.get(i)) == month) {	// date has matching month
					  currentDate = data.get(i);
					  currentDailyMax = -1;	// reset max reading value
				  }
			  }
			  else if(currentDate != 0)	// if current number is a reading and currently tracking
			  {
				  if(data.get(i) > currentDailyMax) { // current reading is larger than previous
					  currentDailyMax = data.get(i);						  
				  }
				  
				  if(isDate(data.get(i+1)) && currentDailyMax >= 0) {	// if next element is a date, thus ends tracking
					  maxReport.add(new MaxHzReport(currentDate, currentDailyMax));
					  currentDate = 0.0;
					  currentDailyMax = -1;		// reset max reading value
				  }
			  }
			  
		  }
	  }
	  
	  return maxReport;
  }
}  


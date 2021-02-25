import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
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
	  
	  double startDate = 0.0;
	  double currentMaxValue = -1;
	  boolean isParsing = false;
	  int counter = 0;
	  
	  LinkedList<MaxHzReport> maxReport = new LinkedList<MaxHzReport>();
	  LinkedList<Double> currentDateInfo = new LinkedList<Double>();
	  
	  for(Double num : data) {	// parse through list and record desired dates and their respective readings
		  counter++;
		  
		  if(isDate(num) && extractMonth(num) == month && !isParsing) {		// if date with matching month, begin parsing
			  startDate = num;
			  isParsing = true;													// sets parsing mode on
		  }
		  else if(isDate(num) && isParsing) {								// reaches another date, stop parsing
			  
			  if(currentDateInfo.size() > 0) {	// if most recent date had valid readings
				  currentMaxValue = findMaxReading(currentDateInfo);			// finds max reading from collected readings
				  maxReport.add(new MaxHzReport(startDate, currentMaxValue));	// adds new MaxHzReport to list
				  currentDateInfo.clear();										// clears readings from readings list
			  }
			  
			  // resets to starting conditions
			  startDate = 0.0;
			  currentMaxValue = -1;
			  isParsing = false;
			  
			  if(extractMonth(num) == month) {	// if stopping date has date with matching month, start parsing again
				  startDate = num;
				  isParsing = true;			// sets parsing mode on
			  }
		  }
		  else if(isParsing) {								// if reading and in parsing mode
			  if(num >= 0) {	// ignoring negative values
				  currentDateInfo.add(num);		// adds reading to external list for processing
			  }
			  
			  
			// if end of the list, and most recent date has valid readings
			  if(counter == data.size() && currentDateInfo.size() > 0.0) {
				  currentMaxValue = findMaxReading(currentDateInfo);	// finds max reading from collected readings
				  maxReport.add(new MaxHzReport(startDate, currentMaxValue));
			  }
		  }
	  }
	  
	  return maxReport;
  }
  
  /**
   * Determines max earthquake reading
   * @param numList, readings to be processed
   * @return maximum earthquake reading
   */
  public double findMaxReading(LinkedList<Double> numList) {
	  double currentMax = 0.0;
	  for(Double num : numList) {
		  if(num > currentMax) {
			  currentMax = num;
		  }
	  }
	  return currentMax;
  }
  
  
  
  
}
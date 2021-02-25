




/**
 * 
 * @author Adam Yang
 * 
 * Results from a skiing event.
 *
 */
public class SkiingResult extends Skiing implements IEvent{

	public SkiingResult(int position,
			double lapOneTime, 
			double lapTwoTime, 
			double lapThreeTime, 
			double lapFourTime,
			int numPenalties) 
	{
		super(position, lapOneTime, lapTwoTime, lapThreeTime, lapFourTime, numPenalties);
	}
	
	
	/**
	 * Sums lap times.
	 * 
	 * @return total lap time.
	 */
	public double pointsEarned()
	{
		
		double totalTime = 0;
		for(Double lapTime: this.laps) {
			totalTime += lapTime;
		}
		return totalTime;
	}
	
	
	/**
	 * Calculates penalties from skiing event.
	 * 
	 * @return total penalties from event.
	 */
	public double getPenalties()
	{
		return 5.0 * numPenalties;
	}
	
	
	
}

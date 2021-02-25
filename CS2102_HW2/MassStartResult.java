
/**
 * 
 * @author Adam Yang
 *
 * Results from a particular type of skiing event.
 *
 */
public class MassStartResult extends Skiing implements IEvent {
	
	int startPosition;
	
	public MassStartResult(int startPosition, 
						int position, 
						double lapOneTime, 
						double lapTwoTime, 
						double lapThreeTime, 
						double lapFourTime, 
						int numPenalties) 
	{
		super(position, lapOneTime, lapTwoTime, lapThreeTime, lapFourTime, numPenalties);
		this.startPosition = startPosition;
	}
	
	/**
	 * Sums lap times.
	 * 
	 * @return Total lap times.
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
	 * Calculates penalties from this event.
	 * 
	 * @return total penalties from event.
	 */
	public double getPenalties()
	{
		return 5.0 * this.numPenalties;
	}
	
}

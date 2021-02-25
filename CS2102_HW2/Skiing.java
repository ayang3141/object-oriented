import java.util.LinkedList;


/**
 * 
 * @author Adam Yang
 *
 * Result from a general skiing event.
 */
public abstract class Skiing {

	int position;
	LinkedList<Double> laps = new LinkedList<Double>();
	int numPenalties;
	
	public Skiing(int position,
			double lapOneTime, 
			double lapTwoTime, 
			double lapThreeTime, 
			double lapFourTime,
			int numPenalties) 
	{
		this.position = position;
		this.laps.add(lapOneTime);
		this.laps.add(lapTwoTime);
		this.laps.add(lapThreeTime);
		this.laps.add(lapFourTime);
		this.numPenalties = numPenalties;
	}
	
	
	
}

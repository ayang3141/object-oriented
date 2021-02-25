
public class SkiingResult implements IEvent{

	
	int position;
	double lapOneTime;
	double lapTwoTime;
	double lapThreeTime;
	double lapFourTime;
	
	int numPenalties;
	
	
	public SkiingResult(int position,
			double lapOneTime, 
			double lapTwoTime, 
			double lapThreeTime, 
			double lapFourTime,
			int numPenalties) 
	{
		this.position = position;
		this.lapOneTime = lapOneTime;
		this.lapTwoTime = lapTwoTime;
		this.lapThreeTime = lapThreeTime;
		this.lapFourTime = lapFourTime;
		this.numPenalties = numPenalties;
	}

	public double pointsEarned()
	{
		return this.lapOneTime + this.lapTwoTime + this.lapThreeTime + this.lapFourTime;
	}
	
	public double getPenalties()
	{
		return 5.0 * numPenalties;
	}
	
	
	
}

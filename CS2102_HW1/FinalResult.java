
public class FinalResult {
	
	ShootingResult shResult;
	SkiingResult skResult;
	
	public FinalResult(ShootingResult shResult, SkiingResult skResult)
	{
		this.shResult = shResult;
		this.skResult = skResult;
	}
	
	
	double finalScore()
	{
		double score = this.shResult.getPenalties() 
				+ this.skResult.getPenalties() 
				+ this.skResult.pointsEarned();
		
		int skiPosition = this.skResult.position;
		
		if(skiPosition == 1)
		{
			score -= 10.0;
		}
		else if(skiPosition == 2)
		{
			score -= 7.0;
		}
		else if(skiPosition == 3)
		{
			score -= 3.0;
		}
		else if(skiPosition == 4)
		{
			score -= 1.0;
		}
		
		
		return score;
	}
}

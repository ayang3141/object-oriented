
public class Athlete {

	String name;
	FinalResult fResult;
	
	
	public Athlete(FinalResult finalResult, String name) 
	{
		this.name = name;
		this.fResult = finalResult;
	}


	boolean betterSkiier(Athlete other)
	{
		if(this.fResult.skResult.pointsEarned() < other.fResult.skResult.pointsEarned())
		{
			return true;
		}
		return false;
	}
	
	boolean betterShooter(Athlete other)
	{
		if(this.fResult.shResult.pointsEarned() > other.fResult.shResult.pointsEarned())
		{
			return true;
		}
		return false;
	}
	
	
	boolean hasBeaten(Athlete other)
	{
		if(this.betterShooter(other) || this.betterSkiier(other))
		{
			return true;
		}
		return false;
	}
	
}

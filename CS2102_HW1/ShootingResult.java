
public class ShootingResult implements IEvent {

	
	ShootingRound round1;
	ShootingRound round2;
	ShootingRound round3;
	ShootingRound round4;
	
	public ShootingResult(ShootingRound round1, 
			ShootingRound round2,
			ShootingRound round3, 
			ShootingRound round4) 
	{
		this.round1 = round1;
		this.round2 = round2;
		this.round3 = round3;
		this.round4 = round4;
	}

	public double pointsEarned()
	{
		return this.round1.getNumHits() 
				+ this.round2.getNumHits() 
				+ this.round3.getNumHits() 
				+ this.round4.getNumHits();
	}
	
	public double getPenalties()
	{
		return 60.0 * (20 - this.pointsEarned());
	}
	
	
	
}

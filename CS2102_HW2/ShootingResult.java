import java.util.LinkedList;

/**
 * 
 * @author Adam Yang
 *
 * Result from a shooting event.
 */
public class ShootingResult implements IEvent {
	LinkedList<ShootingRound> shRoundList = new LinkedList<ShootingRound>();
	
	
	public ShootingResult(LinkedList<ShootingRound> shRoundList) 
	{
		this.shRoundList = shRoundList;
	}

	/**
	 * Sums number of shooting hits.
	 * @return Total number of successful hits.
	 */
	public double pointsEarned() 
	{
		double totalPoints = 0.0;
		for(ShootingRound round : this.shRoundList) {
			totalPoints += round.getNumHits();
		}
		return (double) totalPoints;
	}
	
	/**
	 * Calculates the penalties based on number of hits.
	 * @return Total penalties from event.
	 */
	public double getPenalties() 
	{
		int numRounds = 0;
		for(ShootingRound round : this.shRoundList) {
			numRounds++;
		}
		return 60.0 * (5*numRounds - this.pointsEarned());
	}
	
	/**
	 * Determines the round with most hits from list of rounds.
	 * @param standingStatus whether or not the athlete is standing.
	 * @return ShootingRound object with the most hits
	 */
	public ShootingRound bestRoundByType(boolean standingStatus) 
	{
		ShootingRound bestRound = null;
		int bestScore = -1;	// account for case when best score is zero
		for(ShootingRound round : this.shRoundList) {
			if((round.standing == standingStatus) && (round.getNumHits() > bestScore)) {
				bestRound = round;
			}
		}
		return bestRound;
	}
	
	
	
}

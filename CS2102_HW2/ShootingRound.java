/**
 * 
 * @author Adam Yang
 *
 * Results from a shooting round.
 */
public class ShootingRound {

	boolean standing;
	int numHits;
	
	public ShootingRound(int numHits, boolean standing)	
	{
		this.numHits = numHits;
		this.standing = standing;
	}
	
	/**
	 * Total number of hits.
	 * @return number of successful hits.
	 */
	int getNumHits()
	{
		return this.numHits;
	}
}

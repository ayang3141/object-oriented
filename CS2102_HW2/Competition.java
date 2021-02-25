import java.util.LinkedList;

/**
 * 
 * @author Adam Yang
 *
 * List of athletes and their event results.
 */
public class Competition {

	
	LinkedList<Athlete> athleteList = new LinkedList<Athlete>();
	int numShootingRounds;
	
	public Competition(int numShootingRounds, LinkedList<Athlete> athleteList) 
	{
		this.numShootingRounds = numShootingRounds;
		this.athleteList = athleteList;
	}
	
	/**
	 * Determines the athletes who did not complete their shooting events.
	 * @return LinkedList of athlete names who did not finish.
	 */
	public LinkedList<String> shootingDNF() 
	{
		LinkedList<String> listDNF = new LinkedList<String>();
		
		for(Athlete athlete : this.athleteList) {
			int numRounds = 0;
			
			// Finds number of rounds for particular athlete.
			for(ShootingRound round : athlete.fResult.shResult.shRoundList) {
				numRounds++;
			}
			
			// Determines if particular athlete competed in a enough rounds.
			if(numRounds < this.numShootingRounds) {
				listDNF.add(athlete.name);
			}	
		}
		
		return listDNF;
	}
	
	/**
	 * Calculates final score for particular athlete.
	 * @param athleteName The name of the particular athlete.
	 * @return final score of respective athlete.
	 */
	public double finalScoreForAthlete(String athleteName) 
	{
		double score = 0;
		for(Athlete athlete : this.athleteList) {
			if(athlete.name == athleteName) {
				score = athlete.fResult.finalScore();
			}
		}
		return score;
	}
	
	/**
	 * Determines if any athletes improved from a previous competition
	 * @param previousCompetition Previous competition with athletes and their baseline scores
	 * @return True if at least one athlete improves their score
	 */
	public boolean anyImprovement(Competition previousCompetition) 
	{
		for(Athlete athlete : this.athleteList) {
			for(Athlete sameAthlete : previousCompetition.athleteList) {
				// Determines if same athlete their score form the previous competition
				if((athlete.name == sameAthlete.name) && (athlete.fResult.finalScore() < sameAthlete.fResult.finalScore())) {
					return true;
				}
			}
		}
		return false;
	}
	
	// HW 2, Question 13:
	// In hindsight, I should have wrote a method to replace the chain of methods .fResult.finalScore().
	// This would help make my code cleaner and easier to understand.
	
	
	
	
	
	
	
	
}

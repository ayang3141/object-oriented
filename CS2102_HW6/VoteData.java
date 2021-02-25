import java.util.LinkedList;

/**
 * 
 * @author Adam Yang
 *	
 *	Stores top, second, and third choice votes for particular candidate
 */
public class VoteData {
	
	private int firstChoice;
	private int secondChoice;
	private int thirdChoice;
	
	public VoteData() {
		this.firstChoice = 0;
		this.secondChoice = 0;
		this.thirdChoice = 0;
	}
	
	/**
	 * Records new occurrence of a top vote.
	 */
	public void addFirstChoice() {
		this.firstChoice++;
	}
	
	/**
	 * Records new occurrence of a second choice.
	 */
	public void addSecondChoice() {
		this.secondChoice++;
	}
	
	/**
	 * Records new occurrence of a third choice.
	 */
	public void addThirdChoice() {
		this.thirdChoice++;
	}
	
	/**
	 * Gets the number of top choices.
	 * @return number of top choices.
	 */
	public int getFirstChoices() {
		return this.firstChoice;
	}
	
	/**
	 * Determines the points for this candidate.
	 * @return number of points earned from votes.
	 */
	public int numPoints() {
		return 3*this.firstChoice + 2*this.secondChoice + this.thirdChoice;
	}
	
	

}


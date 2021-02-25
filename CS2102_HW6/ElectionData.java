import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Adam Yang
 *	
 *	Stores Voter and Ballot Information.
 */
public class ElectionData {

	  private LinkedList<String> ballot = new LinkedList<String>();
	  private HashMap<String, VoteData> election = new HashMap<String, VoteData>();
	  
	  
	  Scanner keyboard = new Scanner(System.in);
	  
	  public ElectionData() {}
	  
	  /**
	   * Displays the list of possible candidates to vote for.
	   */
	  public void printBallot() {
		  System.out.println("The candidates are ");
		  for (String s : ballot) {
			  System.out.println(s);
		  }
	  }
	  

	  
	  /**
	   * Processes a vote of the top three candidate choices.
	   * @param first, the top candidate choice.
	   * @param second, the second candidate choice.
	   * @param third, the third candidate choice.
	   * @throws UnknownCandidateException, error due to candidate choice that is not on ballot.
	   * @throws DuplicateVotesException, error due to repeated occurrence of candidate choice.
	   */
	  public void processVote(String first, String second, String third) throws UnknownCandidateException, DuplicateVotesException {
		  // checks if candidates are on ballot
		  if(!this.ballot.contains(first)) {
			  throw new UnknownCandidateException(first);
		  }
		  else if (!this.ballot.contains(second)) {
			  throw new UnknownCandidateException(second);
		  }
		  else if (!this.ballot.contains(third)) {
			  throw new UnknownCandidateException(third);
		  }
		  
		  // checks if any candidate votes are duplicated
		  if(first.equals(second)) {
			  throw new DuplicateVotesException(first);
		  }
		  else if (first.equals(third)) {
			  throw new DuplicateVotesException(first);
		  }
		  else if (second.equals(third)) {
			  throw new DuplicateVotesException(second);
		  }
		  
		  // if valid candidate votes, proceed to process vote
		  VoteData firstCandidate = this.election.get(first);
		  firstCandidate.addFirstChoice();
		  this.election.put(first, firstCandidate);
		  
		  VoteData secondCandidate = this.election.get(second);
		  secondCandidate.addSecondChoice();
		  this.election.put(second, secondCandidate);
		  
		  VoteData thirdCandidate = this.election.get(third);
		  thirdCandidate.addThirdChoice();
		  this.election.put(third, thirdCandidate);
	  }
	  
	  
	  /**
	   * Adds a new candidate to the ballot.
	   * @param candName, the name of the new candidate.
	   * @throws CandidateExistsException, error due to candidate already on the ballot.
	   */
	  public void addCandidate(String candName) throws CandidateExistsException {
		  
		  if(this.ballot.contains(candName)) {	// if candidate is already on ballot
			  throw new CandidateExistsException(candName);
		  }
		  else {	// otherwise, create setup new candidate option
			  this.ballot.add(candName);
			  this.election.put(candName, new VoteData());
		  }
		  
		  
	  }
	  
	  
	  /**
	   * Determines the candidate with the most top votes.
	   * @return name of the winning candidate.
	   */
	  public String findWinnerMostFirstVotes() {
		  int firstPlaceCount = 0;
		  for(String candidate : this.ballot) {
			  firstPlaceCount += this.election.get(candidate).getFirstChoices();
		  }
		  
		  
		  for(String candidate : this.ballot) {
			  double percentage = (double)(this.election.get(candidate).getFirstChoices())/firstPlaceCount;
			  if(percentage > 0.50) {
				  return candidate;
			  }
		  }
		  
		  return "Runoff Required";
	  }
	  
	  
	  /**
	   * Determines the candidate with the most points.
	   * @return name of the winning candidate.
	   */
	  public String findWinnerMostPoints() {
		  int maxPoints = 0;
		  for(String candidate : this.ballot) {
			  int currentPoints = this.election.get(candidate).numPoints();
			  if(currentPoints > maxPoints) {
				  maxPoints = currentPoints;
			  }
		  }

		  
		  for(String candidate : this.ballot) {
			  if(maxPoints == this.election.get(candidate).numPoints()) {
				  return candidate;
			  }
		  }
		  
		  
		  return null;
	  }
	  
	  
	  
	  
}

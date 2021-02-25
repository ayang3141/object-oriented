import java.util.Scanner;


/**
 * 
 * @author Adam Yang
 * 
 * Stores the input/output methods of the election.
 */
public class VotingMachine {
	
	ElectionData election;
	
	Scanner keyboard;
	
	public VotingMachine(ElectionData election) {
		keyboard = new Scanner(System.in);
		this.election = election;
	}
	
	/**
	 * Adds a new candidate to the ballot after requested by user.
	 * @param candidate, name of the new candidate.
	 * @return a message describing if the addition of the candidate was successful or not.
	 */
	public String addWriteIn(String candidate) {
		try {
			this.election.addCandidate(candidate);
		}
		catch(CandidateExistsException error) {
			return error.getName() + " is already on the ballot!";
		}
		return candidate + " was successfully added to the ballot";

	}

	
	/**
	 * Main interface for voting for candidates, prompts user to enter list of their three top candidates.
	 */
	public void votingProcess() {

		this.election.printBallot();
		
		System.out.println("Please list your top three candidate choices: ");
		String candidate1 = keyboard.next();
		keyboard.nextLine();
		String candidate2 = keyboard.nextLine();
		String candidate3 = keyboard.nextLine();
		
		try {
			this.election.processVote(candidate1, candidate2, candidate3);
		}
		catch(UnknownCandidateException error) {
			System.out.println("The candidate " + error.getName() + " is not on the ballot.");
			System.out.println("Would you like to add this candidate to the ballot? (if so, enter Y or y)");
			String reply = keyboard.next();
			if(reply.equals("y") || reply.equals("Y")) {
				String replyResult = this.addWriteIn(error.getName());
				System.out.println(replyResult);
			}
			this.votingProcess();
			
		}
		catch(DuplicateVotesException error) {
			System.out.println("You can't vote for the same candidate twice!");
			this.votingProcess();
		}

		
	}
	
	
}

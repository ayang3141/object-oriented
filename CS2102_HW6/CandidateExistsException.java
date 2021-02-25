/**
 * 
 * @author Adam Yang
 * 
 * Error due to a candidate already on the ballot.
 */
public class CandidateExistsException extends Exception {
	private String name;
	
	public CandidateExistsException(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

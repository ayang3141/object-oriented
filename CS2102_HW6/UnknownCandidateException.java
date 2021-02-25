/**
 * 
 * @author Adam Yang
 * 
 * Error due to a candidate that is NOT on the ballot.
 */
public class UnknownCandidateException extends Exception {
	private String name;
	
	public UnknownCandidateException(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

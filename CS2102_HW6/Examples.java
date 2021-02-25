import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.HashMap;


import org.junit.Test;

public class Examples {
	
	ElectionData ED1 = new ElectionData();
	
	LinkedList<String> gompeiResult1 = new LinkedList<String>();
	LinkedList<String> gompeiResult2 = new LinkedList<String>();
	LinkedList<String> gompeiResult3 = new LinkedList<String>();
	LinkedList<String> gompeiResult4 = new LinkedList<String>();
	LinkedList<String> gompeiResult5 = new LinkedList<String>();
	
	
	
	

	// successful findWinnerMostFirstVotes() call - definite winner
	ElectionData Setup1A() {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}

		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");
		} 
		catch (UnknownCandidateException error) {}
		catch (DuplicateVotesException error) {}

		return(ED);
	}
	
	// successful findWinnerMostFirstVotes() call - definite winner (one vote)
	ElectionData Setup1B() {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}

		// cast votes
		try {
			ED.processVote("husky", "gompei", "ziggy");
		} 
		catch (UnknownCandidateException error) {}
		catch (DuplicateVotesException error) {}

		return(ED);
	}
	
	// findWinnerMostFirstVotes() "runoff required"
	ElectionData Setup2() {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}

		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");
			ED.processVote("husky", "gompei", "ziggy");
		} 
		catch (UnknownCandidateException error) {}
		catch (DuplicateVotesException error) {}

		return(ED);
	}
	
	
	// successful findWinnerMostPoints() call - definite winner
	ElectionData Setup3A() {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}

		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");
		} 
		catch (UnknownCandidateException error) {}
		catch (DuplicateVotesException error) {}

		return(ED);
	}
	
	// successful findWinnerMostPoints() call - definite winner - one vote
	ElectionData Setup3B() {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}

		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
		} 
		catch (UnknownCandidateException error) {}
		catch (DuplicateVotesException error) {}

		return(ED);
	}
	
	// successful findWinnerMostPoints() call - same points
	ElectionData Setup3C() {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}

		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("ziggy", "gompei", "husky");
			ED.processVote("husky", "ziggy", "gompei");
		} 
		catch (UnknownCandidateException error) {}
		catch (DuplicateVotesException error) {}

		return(ED);
	}

	
	// CandidateExistsException is thrown
	ElectionData Setup4() throws CandidateExistsException {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot

		ED.addCandidate("gompei");
		ED.addCandidate("husky");
		ED.addCandidate("ziggy");
		ED.addCandidate("ziggy");


		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");
		} 
		catch (UnknownCandidateException error) {}
		catch (DuplicateVotesException error) {}

		return(ED);
	}
	
	
	// UnknownCandidateException is thrown
	ElectionData Setup5() throws UnknownCandidateException {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}


		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");
			ED.processVote("gotham", "gompei", "ziggy");
		} 
		catch (DuplicateVotesException error) {}

		return(ED);
	}
	
	
	// DuplicateVotesException is thrown
	ElectionData Setup6() throws DuplicateVotesException {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}

		// cast votes
		try {
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("ziggy", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");
		} 
		catch (UnknownCandidateException error) {}


		return(ED);
	}
	
	
	// UnknownCandidateException is thrown when both UnknownCandidateException and DuplicateVotesException exist
	ElectionData Setup7() throws UnknownCandidateException, DuplicateVotesException {
		ElectionData ED = new ElectionData();

		// put candidates on the ballot
		try {
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
		} catch (CandidateExistsException error) {}



		// cast votes
		ED.processVote("gompei", "husky", "ziggy");
		ED.processVote("gompei", "ziggy", "husky");
		ED.processVote("husky", "gompei", "ziggy");
		ED.processVote("gotham", "gompei", "gompei");

		return(ED);
	}

	
	
	public Examples() throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException {

	}
	
	
	
	
	@Test
	public void testFindWinnerMostFirstVotesSuccessful() {
		assertEquals("gompei", Setup1A().findWinnerMostFirstVotes());
	}
	
	@Test
	public void testFindWinnerMostFirstVotesSuccessfulOneVote() {
		assertEquals("husky", Setup1B().findWinnerMostFirstVotes());
	}
	
	@Test
	public void testFindWinnerMostFirstVoteRunoff() {
		assertEquals("Runoff Required", Setup2().findWinnerMostFirstVotes());
	}
	
	@Test
	public void testFindWinnerMostPointsDefiniteWinner() {
		assertEquals("gompei", Setup3A().findWinnerMostPoints());
	}
	
	@Test
	public void testFindWinnerMostPointsDefiniteWinnerOneVote() {
		assertEquals("gompei", Setup3B().findWinnerMostPoints());
	}
	
	@Test
	public void testFindWinnerMostPointsSamePoints() {
		assertEquals("gompei", Setup3C().findWinnerMostPoints());
	}
	
	@Test(expected = CandidateExistsException.class)
	public void testCandidateExistsException() throws CandidateExistsException {
		Setup4();
	}
	
	
	@Test(expected = UnknownCandidateException.class)
	public void testUnknownCandidateException() throws UnknownCandidateException {
		Setup5();
	}
	
	
	@Test(expected = DuplicateVotesException.class)
	public void testDuplicateVotesException() throws DuplicateVotesException {
		Setup6();
	}
	
	@Test(expected = UnknownCandidateException.class)
	public void testBothUnknownAndDuplicateExceptionsExist() throws UnknownCandidateException, DuplicateVotesException {
		Setup7();
	}
	
	
	
	
	
	

}

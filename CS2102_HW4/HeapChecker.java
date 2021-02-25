/**
 * 
 * @author Adam Yang
 * 
 * 
 * checks if given binary tree is a valid answer to a heap operation
 */
public class HeapChecker {


	/**
	 * checks if given binary tree is a valid solution to an element added to a heap.
	 * @param hOrig, the starting heap.
	 * @param elt, the number being added to the heap.
	 * @param hAdded, the resulting binary tree to be verified as a solution.
	 * @return true if hAdded is a valid solution.
	 */
	boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		// Assuming hOrig is a valid Heap.
	 
		// Step 1: check if hAdded is a heap.
		if(!hAdded.isHeap()) {
			return false;
		}
		 
		// Step 2: check if hAdded accounts for all elements in hOrig, plus
		// one more instance of the added element
		if(!hAdded.addEltAllAccountedFor(elt, hOrig)) {
			return false;
		}
		
		// else resulting binary tree is a valid answer.
		return true;
	}

	/**
	 * checks if given binary tree is a valid solution to the root of a heap being removed.
	 * @param hOrig, the starting heap.
	 * @param hRemoved, the resulting binary tree to be verified as a solution.
	 * @return true if hRemoved is a valid solution.
	 */
	boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		// Assuming hOrig is a valid Heap
		//    ...code to compare hOrig and hRemoved as appropriate...
		 
		// Step 1: check if hRemoved is a heap
		if(!hRemoved.isHeap()) { // if hRemoved is not a heap
			return false;
		}
		
		// Step 2: check if hAdded accounts for all elements in hOrig, minus
		// one more instance of the root of hOrig
		if(!hRemoved.remMinEltAllAccountedFor(hOrig)) { // if all elements are not accounted for
			return false;
		}
		 
		// else resulting binary tree is a valid answer
		return true;
	}

}

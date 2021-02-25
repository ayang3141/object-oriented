import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;



// Interface BinTree
interface IBinTree {
	// determines whether element is in the tree
	boolean hasElt(int e);
	
	// returns number of nodes in the tree; counts duplicate elements as separate items
	int size();
	
	// returns depth of longest branch in the tree
	int height();
	
	/*
	 * Added Methods
	 */
	// checks if parent binary tree is a heap
	boolean isHeap();
	
	// checks if sub-binary tree is a heap
	boolean isHeap(int root);
	
	// puts data in binary tree into given ArrayList
	void collectData(ArrayList<Integer> list);
	
	// checks if binary tree is a valid result of adding addedElt to hOrig
	boolean addEltAllAccountedFor(int addedElt, IHeap hOrig);
	
	// checks if binary tree is a valid result of removing root of hOrig
	boolean remMinEltAllAccountedFor(IHeap hOrig);
	
	
}







// Empty Binary Tree
class MtBT implements IBinTree {
	MtBT(){}

	// returns false since empty tree has no elements
	public boolean hasElt(int e) {
		return false;
	}

	// returns 0 since empty tree has no elements
	public int size() {
		return 0;
	}

	// returns 0 since empty tree has no branches
 	public int height() {
 		return 0;
 	}
 	
 	
 	// returns true since empty tree is a heap
 	public boolean isHeap(int root) {
 		return true;
 	}
 	
 	// returns true since empty tree is a heap
 	public boolean isHeap() {
 		return true;
 	}
 	
 	// returns false because 
 	public boolean addEltAllAccountedFor(int addedElt, IHeap hOrig) {
 		return false;
 	}
 	
 	// does nothing since empty tree has no data
 	public void collectData(ArrayList<Integer> list) {}
 	
 	// if hOrig was size 1, then empty tree is a valid result
 	public boolean remMinEltAllAccountedFor(IHeap hOrig) {
 		return hOrig.size() == 1;
 	}
}






// DATA BINARY TREE
class DataBT implements IBinTree {
	int data;
	IBinTree left;
	IBinTree right;

	DataBT(int data, IBinTree left, IBinTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
 
	// an alternate constructor for when both subtrees are empty
	DataBT(int data) {
		this.data = data;
		this.left = new MtBT();
		this.right = new MtBT();
	}

	// determines whether this node or node in subtree has given element
	public boolean hasElt(int e) {
		return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
	}

	// adds 1 to the number of nodes in the left and right subtrees
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	// adds 1 to the height of the taller subtree
	public int height() {
		return 1 + Math.max(this.left.height(), this.right.height());
	}
	
	
	

	/** 
	 * Checks if parent binary tree is a heap
	 * @return true if current binary tree is a heap
	 */
	public boolean isHeap() {
		return this.left.isHeap(this.data) && this.right.isHeap(this.data);
	}
	

	/**
	 * Checks if a subtree is a heap
	 * @param root, the root of the parent binary tree
	 * @return true if the current subtree is a heap
	 */
	public boolean isHeap(int root) {
		
		// if root of current tree is greater than or equal to root of parent tree
		if(root <= this.data) {
			return this.left.isHeap(this.data) && this.right.isHeap(this.data);
		}
		return false;
	}
	
	/**
	 * Collects the data on a binary tree.
	 * @param list, list to collect the data points on the binary tree.
	 */
	public void collectData(ArrayList<Integer> list) {
		
		// adds root of current tree to list
		if(this.size() != 0) {list.add(this.data);}
		

		if(this.left.size() != 0) { // if left subtree exists, recurse
			this.left.collectData(list);
		}
		

		if(this.right.size() != 0) { // if right subtree exists, recurse
			this.right.collectData(list);
		}	
	}
	
	/**
	 * Checks if all elements in starting heap are in the resulting binary tree,
	 * except for one more instance of added element.
	 * @param addedElt, the new element being added.
	 * @param hOrig, the starting heap.
	 * @return true if the current binary tree accounts for all elements after 
	 * adding the new element to the starting heap.
	 */
	public boolean addEltAllAccountedFor(int addedElt, IHeap hOrig) {
		ArrayList<Integer> BTList = new ArrayList<Integer>();
		ArrayList<Integer> HeapList = new ArrayList<Integer>();
		
		this.collectData(BTList); // Collects data from current Binary Tree
		
		hOrig.collectData(HeapList); // Collects data from given heap
		
		
		Collections.sort(BTList); // Sort the data in BTList
		
		// Sort the data in HeapList
		// But, add new element to original Heap
		HeapList.add(addedElt);
		Collections.sort(HeapList);
		
		// Checks if HeapList with added element is same as BTList
		return BTList.equals(HeapList);
	}
	
	
	/**
	 * Checks if all elements in starting heap are in the resulting binary tree,
	 * except for one less instance of the smallest element
	 * @param hOrig, the starting heap.
	 * @return true if the current binary tree accounts for all elements after
	 * the root of the starting heap is removed.
	 */
	public boolean remMinEltAllAccountedFor(IHeap hOrig) {
		ArrayList<Integer> BTList = new ArrayList<Integer>();
		ArrayList<Integer> HeapList = new ArrayList<Integer>();
		
		// Collects data from current Binary Tree
		this.collectData(BTList);
		// Collects data from given heap
		hOrig.collectData(HeapList);
		
		// Sort the data in BTList
		Collections.sort(BTList);
		
		// Sort the data in HeapList
		// But, remove smallest element from original Heap
		int indexSmallest = HeapList.indexOf(Collections.min(HeapList));
		HeapList.remove(indexSmallest);
		Collections.sort(HeapList);
		
		// Checks if HeapList without smallest element is same as BTList
		return BTList.equals(HeapList);
	}
	
}







import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class Examples {

	ArrayList<Integer> collectDataList = new ArrayList<Integer>();
	
	
	
	HeapChecker hChecker = new HeapChecker();
	MtHeap mtHeap = new MtHeap();
	MtBT mtBT = new MtBT();
	
	// ADD_ELT_TESTER_BASE
	/**
	 *         17
	 *        /  \
	 *       20  24
	 */
	DataHeap only20 = new DataHeap(20);
	DataHeap only24 = new DataHeap(24);
	DataHeap addTesterBase = new DataHeap(17, only20, only24);
	
	
	// ADD: result is valid heap A
	/**
	 * 
	 * 			6
	 *  	  /   \
	 * 	     17    20
	 *            /
	 *           24
	 */
//	DataHeap only24 = new DataHeap(24);
	DataHeap only17 = new DataHeap(17);
	DataHeap root20_left24 = new DataHeap(20, only24, mtHeap);
	DataHeap result1 = new DataHeap(6, only17, root20_left24);
	
	
	// ADD: result is valid heap B
	/**
	 * 
	 * 			6
	 *  	  /   \
	 * 	     17    20
	 *         \ 
	 *          24
	 */
//	DataHeap only24 = new DataHeap(24);
//	DataHeap only20 = new DataHeap(20);
	DataHeap root17_right24 = new DataHeap(17, mtHeap, only24);
	DataHeap result2 = new DataHeap(6, root17_right24, only20);
	
	
	// ADD: result is NOT a Heap A
	/**
	 * 
	 * 			17
	 *  	  /   \
	 * 	     6    24
	 *         \ 
	 *          20
	 */
//	DataHeap only24 = new DataHeap(24);
//	DataHeap only20 = new DataHeap(20);
	DataHeap root6_right24 = new DataHeap(6, mtHeap, only20);
	DataHeap result3 = new DataHeap(17, root6_right24, only24);
	
	
	// ADD: result is NOT a Heap B
	/**
	 * 
	 * 			6
	 *         /
	 *        24
	 *       /   \
	 *      17    20
	 *         
	 */
//	DataHeap only20 = new DataHeap(20);
//	DataHeap only17 = new DataHeap(17);
	DataHeap root24_left17_right20 = new DataHeap(24, only17, only20);
	DataHeap result4 = new DataHeap(6, root24_left17_right20, mtHeap);
	
	
	// ADD: result added element wrong # times A
	/**
	 * 
	 * 			  6
	 *          /   \
	 *        6      24
	 *       /  \
	 *      20   17
	 *         
	 */
//	DataHeap only20 = new DataHeap(20);
//	DataHeap only17 = new DataHeap(17);
//	DataHeap only24 = new DataHeap(24);
	DataHeap root6_left20_right17 = new DataHeap(6, only20, only17);
	DataHeap result5 = new DataHeap(6, root6_left20_right17, only24);
	
	
	// ADD: result added element wrong # times B
	/**
	 * 
	 * 			  17
	 *          /   \
	 *        20      24  
	 */
//	DataHeap only20 = new DataHeap(20);
//	DataHeap only24 = new DataHeap(24);
	DataHeap result6 = new DataHeap(17, only20, only24);
	
	
	// ADD: result other element wrong # times A
	/**
	 * 
	 * 			  6
	 *          /   \
	 *        17      17
	 *       /  \
	 *      20   24
	 *         
	 */
//	DataHeap only20 = new DataHeap(20);
//	DataHeap only17 = new DataHeap(17);
//	DataHeap only24 = new DataHeap(24);
	DataHeap root17_left20_right24 = new DataHeap(17, only20, only24);
	DataHeap result7 = new DataHeap(6, root17_left20_right24, only17);
	
	
	// ADD: result other element wrong # times B
	/**
	 * 
	 * 			  6
	 *          /   \
	 *        20      24  
	 */
//	DataHeap only20 = new DataHeap(20);
//	DataHeap only24 = new DataHeap(24);
	DataHeap result8 = new DataHeap(6, only20, only24);
	
	
	// ADD: result total # elements is incorrect
	/**
	 * 
	 * 			  6
	 *          /   \
	 *        17      20
	 *               /   \
	 *             24     30
	 *         
	 */
//	DataHeap only17 = new DataHeap(17);
//	DataHeap only24 = new DataHeap(24);
	DataHeap only30 = new DataHeap(30);
	DataHeap root20_left24_right30 = new DataHeap(20, only24, only30);
	DataHeap result9 = new DataHeap(6, only17, root20_left24_right30);
	
	
	
	
	
	// REMOVE_ELT_TESTER_BASE
	/**
	 *     			17
	 *     	       /  \ 
	 *            20   17
	 *                   \
	 *                   24
	 *                   
	 */
//	DataHeap only24 = new DataHeap(24);
//	DataHeap only20 = new DataHeap(20);
//	DataHeap root17_right24 = new DataHeap(17, mtHeap, only24);
	DataHeap remTesterBase = new DataHeap(17, only20, root17_right24);
	
	
	// REMOVE: Result is a valid Heap
	/**
	 * 	       17
	 *        /  \
	 *      20    24
	 * 
	 * 
	 */
//	DataHeap only24 = new DataHeap(24);
//	DataHeap only20 = new DataHeap(20);
	DataHeap result10 = new DataHeap(17, only20, only24);
	
	
	// REMOVE: Result is NOT a valid Heap
	/**
	 * 	       20
	 *        /  \
	 *      17    24
	 * 
	 * 
	 */
//	DataHeap only24 = new DataHeap(24);
//	DataHeap only17 = new DataHeap(17);
	DataHeap result11 = new DataHeap(20, only17, only24);
	
	
	
	// REMOVE: result removed element occurs wrong # times A
	/**
	 *         20
	 *           \
	 *            24
	 *            
	 */
//	DataHeap only24 = new DataHeap(24);
	DataHeap result12 = new DataHeap(20, mtHeap, only24);
	
	
	// REMOVE: result removed element occurs wrong # times B
	/**
	 * 				17
	 * 		      /    \
	 *          17      17
	 *        /    \
	 *      20      24
	 * 
	 */
//	DataHeap only24 = new DataHeap(24);
//	DataHeap only17 = new DataHeap(17);
//	DataHeap only20 = new DataHeap(20);
//	DataHeap root17_left20_right24 = new DataHeap(17, only20, only24);
	DataHeap result13 = new DataHeap(17, root17_left20_right24, only17);
	
	
	// REMOVE: result other elements wrong # times A
	/**
	 * 	    	 17
	 * 	    	/
	 *        24
	 * 
	 */
//	DataHeap only24 = new DataHeap(24);
	DataHeap result14 = new DataHeap(17, only24, mtHeap);
	
	
	// REMOVE: result other elements wrong # times B
	/**
	 * 			17
	 *         /  \
	 *       20    24
	 *            /
	 *           24
	 *           
	 */
//	DataHeap only24 = new DataHeap(24);
//	DataHeap only20 = new DataHeap(20);
	DataHeap root24_left24 = new DataHeap(24, only24, mtHeap);
	DataHeap result15 = new DataHeap(17, only20, root24_left24);
	
	
	// REMOVE: result total # elements wrong
	/**
	 *         17
	 *        /  \
	 *      20    24
	 *      	 /
	 *          30
	 *          
	 */
//	DataHeap only30 = new DataHeap(30);
//	DataHeap only20 = new DataHeap(20);
	DataHeap root24_left30 = new DataHeap(24, only30, mtHeap);
	DataHeap result16 = new DataHeap(17, only20, root24_left30);
	
	
	// HELPER METHODS
	
	// isHeap()
	/**
	 *             17
	 *            /  \
	 *          20    24
	 * 			  \
	 *             30
	 * 
	 */
//	DataHeap only30 = new DataHeap(30);
//	DataHeap only20 = new DataHeap(20);
	DataHeap root20_right30 = new DataHeap(20, mtHeap, only30);
	DataHeap result17 = new DataHeap(17, root20_right30, only24);
	
	// isHeap(int root)
	// root = 6
	/**
	 * 				17
	 *             /  \
	 *           20    24
	 *           
	 */
//	DataHeap only20 = new DataHeap(20);
//	DataHeap only24 = new DataHeap(24);
	DataHeap result18 = new DataHeap(17, only20, only24);
	
	// collectData(ArrayList<Integer> list)
	/**
	 * 				17
	 *             /  \
	 *           20    24
	 *           
	 */
//	DataHeap only20 = new DataHeap(20);
//	DataHeap only24 = new DataHeap(24);
	DataHeap result19 = new DataHeap(17, only20, only24);
	
	// addEltAllAccountedFor(int addedElt, IHeap hOrig)
	/**
	 * 
	 * 				6
	 *            /   \
	 *          17     20
	 *                   \
	 *                    24
	 * 
	 */
//	DataHeap only17 = new DataHeap(17);
//	DataHeap only24 = new DataHeap(24);
	DataHeap root20_right24 = new DataHeap(20, mtHeap, only24);
	DataHeap result20 = new DataHeap(6, only17, root20_right24);
	
	
	// remMinEltAllAccountedFor(IHeap hOrig)
	// use remTesterBase as hOrig
	// use addTesterBase as result
	
	
	
	
	public Examples() {
		
		collectDataList.add(17);
		collectDataList.add(20);
		collectDataList.add(24);
		
;		
		
	}
	
	
	
	// TESTS FOR ADDTESTER
	@Test
	public void TestAddTesterValidHeapA() {
		assertTrue(hChecker.addEltTester(addTesterBase, 6, result1));
	}
	
	@Test
	public void TestAddTesterValidHeapB() {
		assertTrue(hChecker.addEltTester(addTesterBase, 6, result2));
	}
	
	@Test
	public void TestAddTesterResultNotHeapA() {
		assertFalse(hChecker.addEltTester(addTesterBase, 6, result3));
	}
	
	@Test
	public void TestAddTesterResultNotHeapB() {
		assertFalse(hChecker.addEltTester(addTesterBase, 6, result4));
	}
	
	@Test
	public void TestAddTesterResultAddedEltWrongTimesA() {
		assertFalse(hChecker.addEltTester(addTesterBase, 6, result5));
	}
	
	@Test
	public void TestAddTesterResultAddedEltWrongTimesB() {
		assertFalse(hChecker.addEltTester(addTesterBase, 6, result6));
	}
	
	@Test
	public void TestAddTesterResultOtherEltWrongTimesA() {
		assertFalse(hChecker.addEltTester(addTesterBase, 6, result7));
	}
	
	@Test
	public void TestAddTesterResultOtherEltWrongTimesB() {
		assertFalse(hChecker.addEltTester(addTesterBase, 6, result8));
	}
	
	@Test
	public void TestAddTesterResultTotalEltIncorrect() {
		assertFalse(hChecker.addEltTester(addTesterBase, 6, result9));
	}
	
	@Test
	public void TestAddTesterStartWithEmptyHeap() {
		assertTrue(hChecker.addEltTester(mtHeap, 20, only20));
	}
	
	
	// TESTS FOR REMOVETESTER
//	@Test
//	public void test1() {
//		assertTrue(hChecker.remMinEltTester(addTesterBase, result12));
//	}
	
	@Test
	public void TestRemTesterValidHeap() {
		assertTrue(hChecker.remMinEltTester(remTesterBase, result10));
	}
	
	@Test
	public void TestRemTesterResultNotHeap() {
		assertFalse(hChecker.remMinEltTester(remTesterBase, result11));
	}
	
	@Test
	public void TestRemTesterRemovedEltWrongTimesA() {
		assertFalse(hChecker.remMinEltTester(remTesterBase, result12));
	}
	
	@Test
	public void TestRemTesterRemovedEltWrongTimesB() {
		assertFalse(hChecker.remMinEltTester(remTesterBase, result13));
	}
	
	@Test
	public void TestRemTesterOtherEltWrongTimesA() {
		assertFalse(hChecker.remMinEltTester(remTesterBase, result14));
	}
	
	@Test
	public void TestRemTesterOtherEltWrongTimesB() {
		assertFalse(hChecker.remMinEltTester(remTesterBase, result15));
	}
	
	@Test
	public void TestRemTesterTotalEltIncorrect() {
		assertFalse(hChecker.remMinEltTester(remTesterBase, result16));
	}
	
	@Test
	public void TestRemTesterEndWithEmptyHeap() {
		assertTrue(hChecker.remMinEltTester(only24, mtBT));
	}
	
	
	// TESTS FOR HELPER FUNCTIONS!!!!
	
	// isHeap()
	@Test
	public void testIsHeap() {
		assertTrue(result17.isHeap());
	}
	
	// isHeap(int root)
	@Test
	public void testIsHeapWithRoot() {
		assertTrue(result18.isHeap(6));
	}
	
	// collectData(ArrayList<Integer> list)
	@Test
	public void testCollectData() {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		result19.collectData(tempList);
		Collections.sort(tempList);
		assertEquals(collectDataList, tempList);
	}
	
	// addEltAllAccountedFor(int addedElt, IHeap hOrig)
	@Test
	public void testAddEltAllAccountedFor() {
		assertTrue(result20.addEltAllAccountedFor(6, addTesterBase));
	}
	
	// remMinEltAllAccountedFor(IHeap hOrig)
	@Test
	public void testRemMinEltAllAccountedFor() {
		assertTrue(addTesterBase.remMinEltAllAccountedFor(remTesterBase));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class Examples {

	LinkedList<ShootingRound> shroundlist1 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> shroundlist2 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> shroundlist3 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> shroundlist4 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> shroundlist5 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> shroundlist6 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> shroundlist7 = new LinkedList<ShootingRound>();
	
	LinkedList<Athlete> competitionList1 = new LinkedList<Athlete>();
	LinkedList<Athlete> competitionList2 = new LinkedList<Athlete>();
	LinkedList<Athlete> competitionList3 = new LinkedList<Athlete>();
	LinkedList<Athlete> competitionList4 = new LinkedList<Athlete>();
	LinkedList<Athlete> competitionList5 = new LinkedList<Athlete>();
	LinkedList<Athlete> competitionList6 = new LinkedList<Athlete>();
	LinkedList<Athlete> competitionList7 = new LinkedList<Athlete>();

	
	ShootingResult shresult1 = new ShootingResult(shroundlist1);
	ShootingResult shresult2 = new ShootingResult(shroundlist2);
	ShootingResult shresult3 = new ShootingResult(shroundlist3);
	ShootingResult shresult4 = new ShootingResult(shroundlist4);
	ShootingResult shresult5 = new ShootingResult(shroundlist5);
	ShootingResult shresult6 = new ShootingResult(shroundlist6);
	ShootingResult shresult7 = new ShootingResult(shroundlist6);

	ShootingRound round1 = new ShootingRound(0, true);
	ShootingRound round2 = new ShootingRound(1, true);
	ShootingRound round3 = new ShootingRound(2, true);
	ShootingRound round4 = new ShootingRound(3, true);
	ShootingRound round5 = new ShootingRound(4, true);
	ShootingRound round6 = new ShootingRound(5, true);

	ShootingRound round7 = new ShootingRound(0, false);
	ShootingRound round8 = new ShootingRound(1, false);
	ShootingRound round9 = new ShootingRound(2, false);
	ShootingRound round10 = new ShootingRound(3, false);
	ShootingRound round11 = new ShootingRound(4, false);
	ShootingRound round12 = new ShootingRound(5, false);


	SkiingResult skresult1 = new SkiingResult(1, 1.0, 2.0, 3.0, 4.0, 0);
	SkiingResult skresult2 = new SkiingResult(3, 10.0, 10.0, 10.0, 10.0, 3);
	SkiingResult skresult3 = new SkiingResult(6, 20.0, 20.0, 20.0, 20.0, 8);
	SkiingResult skresult4 = new SkiingResult(1, 0.0, 0.0, 0.0, 0.0, 0);

	MassStartResult msresult1 = new MassStartResult(10, 1, 1.0, 2.0, 3.0, 4.0, 0);
	MassStartResult msresult2 = new MassStartResult(9, 3, 10.0, 10.0, 10.0, 10.0, 3);
	MassStartResult msresult3 = new MassStartResult(8, 6, 20.0, 20.0, 20.0, 20.0, 8);
	MassStartResult msresult4 = new MassStartResult(7, 1, 0.0, 0.0, 0.0, 0.0, 0);
	
	FinalResult finalresult1 = new FinalResult(shresult1, skresult3);	// final score: 120, 0 rounds
	FinalResult finalresult2 = new FinalResult(shresult4, skresult2);	// final score: 652, 4 rounds
	FinalResult finalresult3 = new FinalResult(shresult4, skresult3);	// final score: 720, 4 rounds
	FinalResult finalresult4 = new FinalResult(shresult3, skresult4);	// final score: 590, 2 rounds
	FinalResult finalresult5 = new FinalResult(shresult7, skresult4);	// final score: 50, 2 rounds
	
	// For Competition 1	(Baseline)
	Athlete john1 = new Athlete(finalresult2, "John");
	Athlete steve1 = new Athlete(finalresult3, "Steve");
	Athlete jennifer1 = new Athlete(finalresult4, "Jennifer");
	
	Competition competition1 = new Competition(1, competitionList1);
	Competition competition2 = new Competition(3, competitionList1);
	Competition competition3 = new Competition(5, competitionList1);
	
	// For Competition 2 (No Improvements)
	Athlete john2 = new Athlete(finalresult2, "John");	
	Athlete steve2 = new Athlete(finalresult3, "Steve"); 
	Athlete jennifer2 = new Athlete(finalresult4, "Jennifer");
	
	Competition competition4 = new Competition(1, competitionList2); // No Scramble
	Competition competition5 = new Competition(1, competitionList3); // Scramble
	
	
	// For Competition 2 (At Least One Improvement)
	Athlete john3 = new Athlete(finalresult2, "John");	
	Athlete steve3 = new Athlete(finalresult2, "Steve"); // improvement
	Athlete jennifer3 = new Athlete(finalresult4, "Jennifer");
		
	Competition competition6 = new Competition(1, competitionList4); // No Scramble
	Competition competition7 = new Competition(1, competitionList5); // Scramble
	
	
	// For Competition 2 (At Least One Improvement)
	Athlete john4 = new Athlete(finalresult5, "John");	// improvement
	Athlete steve4 = new Athlete(finalresult5, "Steve"); // improvement
	Athlete jennifer4 = new Athlete(finalresult5, "Jennifer"); // improvement
			
	Competition competition8 = new Competition(1, competitionList6); // No Scramble
	Competition competition9 = new Competition(1, competitionList7); // Scramble
	
	
	
	
	LinkedList<String> dnflist1 = new LinkedList<String>();
	LinkedList<String> dnflist2 = new LinkedList<String>();
	LinkedList<String> dnflist3 = new LinkedList<String>();
	

	@Before
	public void examplesMethod() {

		
		// empty list, so no .add method
		// empty list					[]
		
		// list of 0's, only true		[0, 0]
		shroundlist2.add(round1);
		shroundlist2.add(round1);
		
		// list of 0's, only false		[0, 0]
		shroundlist3.add(round7);
		shroundlist3.add(round7);
		
		// only true					[1, 2, 3, 4]
		shroundlist4.add(round2);
		shroundlist4.add(round3);
		shroundlist4.add(round4);
		shroundlist4.add(round5);
		
		// only false					[1, 2, 3, 4]
		shroundlist5.add(round8);
		shroundlist5.add(round9);
		shroundlist5.add(round10);
		shroundlist5.add(round11);
		
		// mix							[0, 3, 2, 5]
		shroundlist6.add(round1);
		shroundlist6.add(round4);
		shroundlist6.add(round9);
		shroundlist6.add(round12);
		
		// perfect						[4, 5]
		shroundlist7.add(round5);
		shroundlist7.add(round6);
		
		
		
		
		
		// Competition 1 (baseline)
		competitionList1.add(john1);
		competitionList1.add(steve1);
		competitionList1.add(jennifer1);
		
		// Competition 2 (No improvement)
		competitionList2.add(john2);	// no scramble
		competitionList2.add(steve2);
		competitionList2.add(jennifer2);
		
		competitionList3.add(jennifer2);	// scramble
		competitionList3.add(john2);
		competitionList3.add(steve2);
		
		// Competition 2 (At Least One Improvement)
		competitionList4.add(john3);	// no scramble
		competitionList4.add(steve3);
		competitionList4.add(jennifer3);
				
		competitionList5.add(jennifer3);	// scramble
		competitionList5.add(john3);
		competitionList5.add(steve3);
		
		// Competition 3 (All Improvement)
		competitionList6.add(john4);	// no scramble
		competitionList6.add(steve4);
		competitionList6.add(jennifer4);
						
		competitionList7.add(jennifer4);	// scramble
		competitionList7.add(john4);
		competitionList7.add(steve4);
		
		
		// dnflist2
		dnflist2.add("Jennifer");
		
		// dnflist3
		dnflist3.add("John");
		dnflist3.add("Steve");
		dnflist3.add("Jennifer");
		
		
		
		
		
		
	}
	
	
		// test cases for pointsEarned for SkiingResults
	@Test
	public void testPointsEarnedSkiingResultsBest() {
		assertEquals(10.0, skresult1.pointsEarned(), 0.01);
	}

	@Test
	public void testPointsEarnedSkiingResultsWeird() {
		assertEquals(0.0, skresult4.pointsEarned(), 0.01);
	}

	@Test
	public void testPointsEarnedSkiingResultsWorst() {
		assertEquals(80.0, skresult3.pointsEarned(), 0.01);
	}


	// test cases for pointsEarned for MassStartResults
	@Test
	public void testPointsEarnedMassStartResultsBest() {
		assertEquals(10.0, msresult1.pointsEarned(), 0.01);
	}

	@Test
	public void testPointsEarnedMassStartResultsWeird() {
		assertEquals(0.0, msresult4.pointsEarned(), 0.01);
	}

	@Test
	public void testPointsEarnedMassStartResultsWorst() {
		assertEquals(80.0, msresult3.pointsEarned(), 0.01);
	}


	// test cases for PointsEarned in Shooting Result
	@Test
	public void testPointsEarnedShootingResultNull() {
		assertEquals(0.0, shresult1.pointsEarned(), 0.01);
	}
	
	@Test
	public void testPointsEarnedShootingResultOnlyZeros() {
		assertEquals(0.0, shresult2.pointsEarned(), 0.01);
	}
	
	@Test
	public void testPointsEarnedShootingResultMixed() {
		assertEquals(10.0, shresult4.pointsEarned(), 0.01);
	}
	
	
	// test cases for bestRoundByType
	@Test
	public void testBestRoundByTypeTrueWithEmptyList() {
		assertEquals(null, shresult1.bestRoundByType(true));
	}
	
	@Test
	public void testBestRoundByTypeTrueOnlyTrue() {
		assertEquals(round5, shresult4.bestRoundByType(true));
	}
	
	@Test
	public void testBestRoundByTypeTrueOnlyFalse() {
		assertEquals(null, shresult5.bestRoundByType(true));
	}
	
	@Test
	public void testBestRoundByTypeTrueWithTrueAndFalse() {
		assertEquals(round4, shresult6.bestRoundByType(true));
	}
	
	@Test
	public void testBestRoundByTypeFalseWithEmptyList() {
		assertEquals(null, shresult1.bestRoundByType(false));
	}
	
	@Test
	public void testBestRoundByTypeFalseOnlyTrue() {
		assertEquals(null, shresult4.bestRoundByType(false));
	}
	
	@Test
	public void testBestRoundByTypeFalseOnlyFalse() {
		assertEquals(round11, shresult5.bestRoundByType(false));
	}
	
	@Test
	public void testBestRoundByTypeFalseWithTrueAndFalse() {
		assertEquals(round12, shresult6.bestRoundByType(false));
	}
	
	
	// test case for shootingDNF
	@Test
	public void testShootingDNFNoneDNF() {
		assertEquals(dnflist1, competition1.shootingDNF());
	}
	
	@Test
	public void testShootingDNFAtLeastOneDNF() {
		assertEquals(dnflist2, competition2.shootingDNF());
	}
	
	@Test
	public void testShootingDNFALLDNF() {
		assertEquals(dnflist3, competition3.shootingDNF());
	}
	
	
	// test cases for finalScoreForAthlete
	@Test
	public void testFinalScoreForAthleteOneWithFourRounds() {
		assertEquals(652.0, competition1.finalScoreForAthlete("John"), 0.01);
	}
	
	@Test
	public void testFinalScoreForAthleteOneWithTwoRounds() {
		assertEquals(590.0, competition1.finalScoreForAthlete("Jennifer"), 0.01);
	}
	
	
	// test cases for anyImprovement
	@Test
	public void testAnyImprovementNoImprovmentsWithNoScramble() {
		assertFalse(competition4.anyImprovement(competition1));
	}
	
	@Test
	public void testAnyImprovementAtLeastOneWithNoScramble() {
		assertTrue(competition6.anyImprovement(competition1));
	}
	
	@Test
	public void testAnyImprovementAllWithNoScramble() {
		assertTrue(competition8.anyImprovement(competition1));
	}
	
	@Test
	public void testAnyImprovementNoImprovmentsWithScramble() {
		assertFalse(competition5.anyImprovement(competition1));
	}
	
	@Test
	public void testAnyImprovementAtLeastOneWithScramble() {
		assertTrue(competition7.anyImprovement(competition1));
	}
	
	@Test
	public void testAnyImprovementAllWithScramble() {
		assertTrue(competition9.anyImprovement(competition1));
	}
	
	






	




}
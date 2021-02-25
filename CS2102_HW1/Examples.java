import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

	ShootingRound shootingRound1 = new ShootingRound(0);
    ShootingRound shootingRound2 = new ShootingRound(1);
    ShootingRound shootingRound3 = new ShootingRound(2);
    ShootingRound shootingRound4 = new ShootingRound(3);
    ShootingRound shootingRound5 = new ShootingRound(4);
    ShootingRound shootingRound6 = new ShootingRound(5);
    
    
    
    
    ShootingResult shootingResult1 = new ShootingResult(shootingRound2, shootingRound3, shootingRound4, shootingRound5);
    ShootingResult shootingResult2 = new ShootingResult(shootingRound1, shootingRound1, shootingRound1, shootingRound1);
    ShootingResult shootingResult3 = new ShootingResult(shootingRound6, shootingRound6, shootingRound6, shootingRound6);
    
    SkiingResult skiingResult1 = new SkiingResult(4, 15.0, 17.0, 10.0, 13.0, 4);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    SkiingResult skiingResult2 = new SkiingResult(1, 9.0, 7.0, 10.0, 9.0, 2);
    SkiingResult skiingResult3 = new SkiingResult(6, 20.0, 23.0, 21.0, 19.0, 8);
    SkiingResult skiingResult4 = new SkiingResult(1, 0.0, 0.0, 0.0, 0.0, 0);
    
    
    
    FinalResult finalResult1 = new FinalResult(shootingResult2, skiingResult4);
    FinalResult finalResult2 = new FinalResult(shootingResult3, skiingResult3);
    FinalResult finalResult3 = new FinalResult(shootingResult1, skiingResult1);
    FinalResult finalResult4 = new FinalResult(shootingResult2, skiingResult3);
    
    Athlete athlete1 = new Athlete(finalResult1);
    Athlete athlete2 = new Athlete(finalResult2);
    Athlete athlete3 = new Athlete(finalResult3);
    Athlete athlete4 = new Athlete(finalResult1);
    Athlete athlete5 = new Athlete(finalResult4);
	
	
	// Test Cases for ShootingResult Class
	@Test
	public void shootingResultPointTestwithNonZero() {
		assertEquals(10.0, shootingResult1.pointsEarned(), 0.01);
	}
	
	@Test
	public void shootingResultPointTestAllZero() {
		assertEquals(0.0, shootingResult2.pointsEarned(), 0.01);
	}
	
	@Test
	public void shootingResultPointTestPerfect() {
		assertEquals(20.0, shootingResult3.pointsEarned(), 0.01);
	}
	
	@Test
	public void shootingResultPenaltyTestMixed() {
		assertEquals(600.0, shootingResult1.getPenalties(), 0.01);
	}
	
	@Test
	public void shootingResultPenaltyTestMissedAll() {
		assertEquals(1200.0, shootingResult2.getPenalties(), 0.01);
	}
	
	@Test
	public void shootingResultPenaltyTestPerfect() {
		assertEquals(0.0, shootingResult3.getPenalties(), 0.01);
	}
	
	
	// Test Cases for SkiingResult Class
	
	@Test
	public void skiingResultPointTestFourth() {
		assertEquals(55.0, skiingResult1.pointsEarned(), 0.01);
	}
	
	@Test
	public void skiingResultPointTestFirst() {
		assertEquals(35.0, skiingResult2.pointsEarned(), 0.01);
	}
	
	@Test
	public void skiingResultPointTestSixth() {
		assertEquals(83.0, skiingResult3.pointsEarned(), 0.01);
	}
	
	@Test
	public void skiingResultPenaltyTestFourth() {
		assertEquals(20.0, skiingResult1.getPenalties(), 0.01);
	}
	
	@Test
	public void skiingResultPenaltyTestSixth() {
		assertEquals(40.0, skiingResult3.getPenalties(), 0.01);
	}
	
	
	
	// Test Cases for finalScore
	
	@Test
	public void finalScoreTestVeryLowValues() {
		assertEquals(1190.0, finalResult1.finalScore(), 0.01);
	}
	
	@Test
	public void finalScoreTestVeryHighValues() {
		assertEquals(123.0, finalResult2.finalScore(), 0.01);
	}
	
	@Test
	public void finalScoreTestMixedValues() {
		assertEquals(674.0, finalResult3.finalScore(), 0.01);
	}
	
	
	// Test Cases for betterSkiier
	
	@Test
	public void betterSkiierDifferentScore() {
		assertTrue(athlete3.betterSkiier(athlete2));
	}
	
	@Test
	public void betterSkiierSameScore() {
		assertFalse(athlete1.betterSkiier(athlete4));
	}
	
	
	// Test Cases for betterShooter
	
	@Test
	public void betterShooterDifferentScore() {
		assertTrue(athlete2.betterShooter(athlete3));
	}
	
	@Test
	public void betterShooterSameScore() {
		assertFalse(athlete1.betterShooter(athlete4));
	}
	
	
	// Test Cases for hasBeaten
	
	@Test
	public void hasBeatenBetterSkiier() {
		assertTrue(athlete3.hasBeaten(athlete2));
	}
	
	@Test
	public void hasBeatenBetterShooter() {
		assertTrue(athlete2.hasBeaten(athlete3));
	}
	
	@Test
	public void hasBeatenNotBetter() {
		assertFalse(athlete5.hasBeaten(athlete3));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

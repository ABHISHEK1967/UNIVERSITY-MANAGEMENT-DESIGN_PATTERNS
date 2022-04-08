package edu.dalhousie.business.sportsnomination.model;

import edu.dalhousie.business.sportnomination.model.SportsNominationModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SportsNominationModelTest {

    private static SportsNominationModel sportsNominationModel;

    @BeforeAll
    public static void setFields() {
        sportsNominationModel = new SportsNominationModel("viren.malavia", "Football", 4, 2, 1, 2020, 2016, 2021, 1, 0, 1, 2, 3, 4);
    }

    @Test
    public void testusername() {
        assertEquals("viren.malavia", sportsNominationModel.getUsername());
    }

    @Test
    public void testsport() {
        assertEquals("Football", sportsNominationModel.getSport());
    }

    @Test
    public void testawards() {
        assertEquals(4, sportsNominationModel.getAwards());
    }

    @Test
    public void testachievementlevel() {
        assertEquals(2, sportsNominationModel.getAchievementLevel());
    }

    @Test
    public void testmedal() {
        assertEquals(1, sportsNominationModel.getMedal());
    }

    @Test
    public void testyear() {
        assertEquals(2020, sportsNominationModel.getYear());
    }

    @Test
    public void testmaxGapYear() {
        assertEquals(2016, sportsNominationModel.getMaxGapYear());
    }

    @Test
    public void testcurrentYear() {
        assertEquals(2021, sportsNominationModel.getCurrentYear());
    }

    @Test
    public void testyearPoints() {
        assertEquals(1, sportsNominationModel.getYearPoints());
    }

    @Test
    public void testlevelZero() {
        assertEquals(0, sportsNominationModel.getLevelZero());
    }

    @Test
    public void testlevelOne() {
        assertEquals(1, sportsNominationModel.getLevelOne());
    }

    @Test
    public void testlevelTwo() {
        assertEquals(2, sportsNominationModel.getLevelTwo());
    }

    @Test
    public void testlevelThree() {
        assertEquals(3, sportsNominationModel.getLevelThree());
    }

    @Test
    public void testlevelFour() {
        assertEquals(4, sportsNominationModel.getLevelFour());
    }

}
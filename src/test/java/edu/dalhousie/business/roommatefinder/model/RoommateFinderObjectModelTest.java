package edu.dalhousie.business.roommatefinder.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoommateFinderObjectModelTest {

    public static RoommateFinderObjectModel roommateFinderObjectModel;

    @BeforeAll
    public static void setup() {
        roommateFinderObjectModel = new RoommateFinderObjectModel("vignesh", 1, 1, 2, "food", 1, 1, 12345);
    }

    @Test
    public void testUserName() {
        assertEquals("vignesh", roommateFinderObjectModel.getUserName());
    }

    @Test
    public void testGender() {
        assertEquals(1, roommateFinderObjectModel.getGender());
    }

    @Test
    public void testFoodPreference() {
        assertEquals(1, roommateFinderObjectModel.getFoodPreference());
    }

    @Test
    public void testGenderPreference() {
        assertEquals(2, roommateFinderObjectModel.getGenderPreference());
    }

    @Test
    public void testHobbies() {
        assertEquals("food", roommateFinderObjectModel.getHobbies());
    }

    @Test
    public void testCampusPreference() {
        assertEquals(1, roommateFinderObjectModel.getCampusPreference());
    }

    @Test
    public void testAccomodationPreference() {
        assertEquals(1, roommateFinderObjectModel.getAccomodationPreference());
    }

    @Test
    public void testPriority() {
        assertEquals(12345, roommateFinderObjectModel.getPriority());
    }
}
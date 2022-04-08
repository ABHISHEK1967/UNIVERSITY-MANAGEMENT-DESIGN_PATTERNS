package edu.dalhousie.business.roommatefinder.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateRoommateFinderTest {

    @Test
    public void testVerifyGender() {
        ValidateRoommateFinder validate = new ValidateRoommateFinder();
        assertEquals(true, validate.verifyGender(1));
    }

    @Test
    public void testVerifyFood() {
        ValidateRoommateFinder validate = new ValidateRoommateFinder();
        assertEquals(true, validate.verifyFood(3));
    }

    @Test
    public void testVerifyGenderPreference() {
        ValidateRoommateFinder validate = new ValidateRoommateFinder();
        assertEquals(true, validate.verifyGenderPreference(3));
    }

    @Test
    public void testVerifyCampus() {
        ValidateRoommateFinder validate = new ValidateRoommateFinder();
        assertEquals(true, validate.verifyCampus(2));
    }

    @Test
    public void testVerifyAccomodation() {
        ValidateRoommateFinder validate = new ValidateRoommateFinder();
        assertEquals(true, validate.verifyAccomodation(2));
    }

}
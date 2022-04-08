package edu.dalhousie.business.viewprofile.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewProfileModelTest {

    private static ViewProfileModel viewProfileModel;

    @BeforeAll
    public static void setFields() {
        viewProfileModel = new ViewProfileModel("viren.malavia", "viren", "malavia", "viren@gmail.com", "9029897997", "12-24-1998", "Male", "Walter Havill Dr", "8", "Halifax", "Nova Scotia", "B3N 5RK", "viren.malavia");
    }

    @Test
    public void testusername() {
        assertEquals("viren.malavia", viewProfileModel.getUsername());
    }

    @Test
    public void testfirstName() {
        assertEquals("viren", viewProfileModel.getFirstName());
    }

    @Test
    public void testlastName() {
        assertEquals("malavia", viewProfileModel.getLastName());
    }

    @Test
    public void testemail() {
        assertEquals("viren@gmail.com", viewProfileModel.getEmail());
    }

    @Test
    public void testcontactNumber() {
        assertEquals("9029897997", viewProfileModel.getContactNumber());
    }

    @Test
    public void testdateOfBirth() {
        assertEquals("12-24-1998", viewProfileModel.getDateOfBirth());
    }

    @Test
    public void testgender() {
        assertEquals("Male", viewProfileModel.getGender());
    }

    @Test
    public void teststreetAddress() {
        assertEquals("Walter Havill Dr", viewProfileModel.getStreetAddress());
    }

    @Test
    public void testapartmentNumber() {
        assertEquals("8", viewProfileModel.getApartmentNumber());
    }

    @Test
    public void testcity() {
        assertEquals("Halifax", viewProfileModel.getCity());
    }

    @Test
    public void testprovince() {
        assertEquals("Nova Scotia", viewProfileModel.getProvince());
    }

    @Test
    public void testzipcode() {
        assertEquals("B3N 5RK", viewProfileModel.getZipcode());
    }

    @Test
    public void testuserID() {
        assertEquals("viren.malavia", viewProfileModel.getUserID());
    }

}
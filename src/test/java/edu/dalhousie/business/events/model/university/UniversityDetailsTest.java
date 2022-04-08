package edu.dalhousie.business.events.model.university;

import edu.dalhousie.business.events.model.University.UniversityDetails;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UniversityDetailsTest {
    private static UniversityDetails universityDetails;
    @BeforeAll
    public static void setUp() {
        universityDetails = Mockito.mock(UniversityDetails.class);
    }

    @Test
    public void sendNotificationTest(){
        universityDetails.sendNotificationToUniversity("dalhousie");
        verify(universityDetails,times(1))
                .sendNotificationToUniversity("dalhousie");
    }
}

package edu.dalhousie.business.sportsnomination.controller;

import edu.dalhousie.business.sportnomination.controller.SportsNomination;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SportsNominationTest {

    ICommonPrinting viewMock = Mockito.mock(ICommonPrinting.class);
    SportsNomination sportsNomination = new SportsNomination();

    @BeforeEach
    public void init() throws  Exception {
        FieldSetter viewField = new FieldSetter(sportsNomination, SportsNomination.class.getDeclaredField("view"));
        viewField.set(viewMock);
    }

    @Test
    public void testSportsNomination() {
        Mockito.when(viewMock.getString()).thenReturn("viren.malavia", "Football");
        Mockito.when(viewMock.getInt()).thenReturn(4, 2, 2, 2018);
        assertEquals("\nCongratulations viren.malavia! You are eligible to be a part of our Football sports club.", sportsNomination.sportsNominationChecker());
    }
}

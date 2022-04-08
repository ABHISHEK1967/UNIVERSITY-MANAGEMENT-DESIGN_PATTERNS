package edu.dalhousie.business.dalmembership.controller.menu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuTest {
    private static Menu menu;
    @BeforeAll
    public static void setUp() {
        menu = Mockito.mock(Menu.class);
    }

    @Test
    protected void ClassExistenceTest(){
        Menu menu = Menu.getInstance();
        assertNotNull(menu);
    }

    @Test
    public void showExistingBalanceTest(){
        menu.start();
        verify(menu,times(1)).start();
    }
}

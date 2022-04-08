package edu.dalhousie.business.dalmembership.controller.balance;
import edu.dalhousie.database.IDatabaseConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
public class BalanceTest {
    private static Balance balance;
    private IDatabaseConnection IDatabaseConnection ;

    @BeforeAll
    public static void setUp() {
        balance = Mockito.mock(Balance.class);
    }

    @Test
    public void showExistingBalanceTest(){
        balance.showExistingBalance(IDatabaseConnection);
        verify(balance,times(1)).showExistingBalance(IDatabaseConnection);
    }

    @Test
    void checkIfBalanceClassIsNull() {
        IBalance balance = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            balance.rechargeBalance(IDatabaseConnection,1000);
        });
    }

    @Test
    void testIfBalanceClassImplementsInterface() {
        Assertions.assertTrue(IBalance.class.isAssignableFrom(Balance.class));
    }
}

/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.database.balance;
import edu.dalhousie.business.dalmembership.database.balance.updateBalance.UpdateBalanceQueryBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UpdateBalanceQueryBuilderTest {
    @Test
    public void updateBalanceQuery(){
        UpdateBalanceQueryBuilder updateBalanceQueryBuilder
                = UpdateBalanceQueryBuilder.getInstance();
        String actualQuery = "UPDATE membership_details " +
                "SET balance = balance + 100.0 WHERE member_id = 1";
        String expectedQuery = updateBalanceQueryBuilder
                .rechargeBalanceQuery(1,100);
        assertEquals(expectedQuery,actualQuery);
    }
}

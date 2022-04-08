/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.database.subscription;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateSubscriptionQueryBuilderTest {
    @Test
    public void updateSubscriptionQuery(){
        UpdateSubscriptionQueryBuilder updateSubscriptionQueryBuilder
                = UpdateSubscriptionQueryBuilder.getInstance();
        String actualQuery = updateSubscriptionQueryBuilder
                .updateSubscriptionQuery(1,"bronze");
        String expectedQuery =  "UPDATE membership_details " +
                "SET subscription = 'bronze' WHERE member_id = 1";
        assertEquals(expectedQuery,actualQuery);
    }
}

/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.tender.database;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TenderWinnerQueryBuilderTest {
    @Test
    public void updateWinner(){
        TenderWinnerQueryBuilder tenderWinnerQueryBuilder
                = TenderWinnerQueryBuilder.getInstance();
        String expectedQuery = tenderWinnerQueryBuilder.updateWinner("flash");
        String actualQuery = "INSERT INTO tender (bidder) VALUES('flash')";
        assertEquals(expectedQuery,actualQuery);
    }
}

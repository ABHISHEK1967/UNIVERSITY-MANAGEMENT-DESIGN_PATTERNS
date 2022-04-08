/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.database;
import static edu.dalhousie.business.events.database.WinnerConstant.*;

public class InsertWinnerNameQueryBuilder implements IInsertWinnerNameDAOQueryBuilder{
    @Override
    public String insertWinnerName(String winnerName) {
        return "INSERT INTO " +
                WINNER_TABLE +
                " (" + WINNER_NAME + ")" +
                " VALUES " + "('" + winnerName + "')";

    }
}

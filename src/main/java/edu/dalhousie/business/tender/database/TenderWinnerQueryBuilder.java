/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.tender.database;

import static edu.dalhousie.business.tender.database.TenderConstants.*;

public class TenderWinnerQueryBuilder implements ITenderWinnerDAOQueryBuilder {
    private static  TenderWinnerQueryBuilder tenderWinnerQueryBuilder;

    private TenderWinnerQueryBuilder(){

    }
    public static TenderWinnerQueryBuilder getInstance(){
        if(tenderWinnerQueryBuilder==null){
            tenderWinnerQueryBuilder = new TenderWinnerQueryBuilder();
        }
        return tenderWinnerQueryBuilder;
    }

    @Override
    public String updateWinner(String winnerName) {
        return "INSERT INTO " +
                TENDER_TABLE +
                " (bidder) " + "VALUES("+"'"+winnerName+"'"+")";


    }
}

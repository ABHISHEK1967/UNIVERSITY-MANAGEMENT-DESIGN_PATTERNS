package edu.dalhousie.business.dalmembership.database.balance.updateBalance;

import static edu.dalhousie.business.dalmembership.database.MembershipDetailsConstant.*;

public class UpdateBalanceQueryBuilder implements IUpdateBalanceDAOQueryBuilder {
    private static UpdateBalanceQueryBuilder updateBalanceQueryBuilder;
    private UpdateBalanceQueryBuilder(){

    }
    public static UpdateBalanceQueryBuilder getInstance(){
        if(updateBalanceQueryBuilder == null){
            updateBalanceQueryBuilder = new UpdateBalanceQueryBuilder();
        }
        return updateBalanceQueryBuilder;
    }
    @Override
    public String rechargeBalanceQuery(int id, double amount) {
        return "UPDATE "+
                MEMBERSHIP_TABLE +
                " SET " +
                BALANCE + " = " + BALANCE + " + " + amount +
                " WHERE "+
                MEMBER_ID +" = " + id;
    }
}

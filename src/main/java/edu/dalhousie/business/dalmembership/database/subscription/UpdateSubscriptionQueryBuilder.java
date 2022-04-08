package edu.dalhousie.business.dalmembership.database.subscription;

import static edu.dalhousie.business.dalmembership.database.MembershipDetailsConstant.*;

public class UpdateSubscriptionQueryBuilder implements IUpdateSubscriptionDAOQueryBuilder{
    private static UpdateSubscriptionQueryBuilder updateSubscriptionQueryBuilder;
    private UpdateSubscriptionQueryBuilder(){

    }
    public static UpdateSubscriptionQueryBuilder getInstance(){
        if(updateSubscriptionQueryBuilder == null){
            updateSubscriptionQueryBuilder = new UpdateSubscriptionQueryBuilder();
        }
        return updateSubscriptionQueryBuilder;
    }
    @Override
    public String updateSubscriptionQuery(int id,String subscription) {
        return  "UPDATE "+
                MEMBERSHIP_TABLE +
                " SET " +
                SUBSCRIPTION + " = '" + subscription + "'" +
                " WHERE "+
                MEMBER_ID +" = " + id;
    }
}

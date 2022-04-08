package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.business.dalmembership.controller.handler.BronzeHandler;
import edu.dalhousie.business.dalmembership.controller.handler.Handler;
import edu.dalhousie.business.dalmembership.database.balance.updateBalance.UpdateBalanceQueryBuilder;
import edu.dalhousie.business.dalmembership.database.subscription.UpdateSubscriptionQueryBuilder;
import edu.dalhousie.controllers.User;
import edu.dalhousie.database.IDatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.function.BiPredicate;

public class SubscriptionImplementation implements ISubscriptionImplmentation{
    private Subscription subscription = null;
    private Handler handler;
    UpdateSubscriptionQueryBuilder updateSubscriptionQueryBuilder;
    UpdateBalanceQueryBuilder updateBalanceQueryBuilder;
    public SubscriptionImplementation(){
        this.updateSubscriptionQueryBuilder = UpdateSubscriptionQueryBuilder.getInstance();
        this.updateBalanceQueryBuilder = UpdateBalanceQueryBuilder.getInstance();
        handler = new BronzeHandler();
    }
    @Override
    public Subscription subscribe(String choice, Double duration,
                                  User user,
                                  IDatabaseConnection IDatabaseConnection) throws Exception {
        if (choice.isEmpty() || duration == 0 || user == null) {
            throw new NullPointerException("values can't be null");
        }

        subscription = subscriptionFactory(choice);

        BiPredicate<Double, Double> eligibility = subscription.checkEligibility();

        if (!eligibility.test(duration, user.getBalance())) {
            throw new Exception("account balance is low, refill the same " +
                    "in order to subscribe the plan");
        }

        subscription.initializeBasicSubscription();
        user.setBalance(user.getBalance() - subscription.getMonthlyCharges());
        user.setCurrentSubscription(subscription);

        final Connection connection =
                IDatabaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
        statement.executeUpdate(this.updateSubscriptionQueryBuilder
                .updateSubscriptionQuery(
                        user.getUserId(),
                        user.getCurrentSubscription().subscriptionName
                ));
        statement.executeUpdate(this.updateBalanceQueryBuilder
                .rechargeBalanceQuery(
                        user.getUserId(),
                        user.getCurrentSubscription().getTotalAmount()
                ));
        return subscription;
    }

    private Subscription subscriptionFactory(String choice) throws Exception {
        return handler.processNextRequest(choice);
    }
}

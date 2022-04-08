/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.balance;

import edu.dalhousie.Main;
import edu.dalhousie.business.dalmembership.database.balance.getBalance.GetBalanceQueryBuilder;
import edu.dalhousie.business.dalmembership.database.balance.updateBalance.UpdateBalanceQueryBuilder;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Balance implements IBalance{
    UserSession userSession;
    GetBalanceQueryBuilder balanceQueryBuilder;
    UpdateBalanceQueryBuilder rechargeBalanceQueryBuilder;
    private static ILogger logger = LoggerAbstractFactory
            .getFactory().newLoggerInstance();
    public Balance(){
        userSession = UserSession.getInstance();
        this.balanceQueryBuilder = GetBalanceQueryBuilder.getInstance();
        this.rechargeBalanceQueryBuilder = UpdateBalanceQueryBuilder.getInstance();
    }
    @Override
    public void showExistingBalance(IDatabaseConnection IDatabaseConnection) {
        try {
            final Connection connection =
                    IDatabaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            final ResultSet balanceAmount = statement
                    .executeQuery(
                            this.balanceQueryBuilder
                            .selectBalanceQuery(userSession.getUser().getUserId())
            );
            while (balanceAmount.next()) {
                System.out.println("The balance AVAILABLE in your account is: "
                        + balanceAmount.getInt("balance"));
            }

        }catch (Exception e){
            logger.error(Balance.class.toString(),e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void rechargeBalance(IDatabaseConnection IDatabaseConnection, double amount){
        try {
            final Connection connection =
                    IDatabaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            statement.executeUpdate(this.rechargeBalanceQueryBuilder
                    .rechargeBalanceQuery(
                            userSession.getUser().getUserId(), amount
            ));

        }catch (Exception e){
            logger.error(Balance.class.toString(),e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}

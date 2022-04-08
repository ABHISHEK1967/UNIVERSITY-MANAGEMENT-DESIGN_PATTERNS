/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.balance;

import edu.dalhousie.database.IDatabaseConnection;

public interface IBalance {
    void showExistingBalance(IDatabaseConnection IDatabaseConnection);
    void rechargeBalance(IDatabaseConnection IDatabaseConnection, double amount) throws Exception;
}

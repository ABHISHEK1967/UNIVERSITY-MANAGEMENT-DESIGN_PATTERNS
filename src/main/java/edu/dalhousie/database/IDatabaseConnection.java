/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.database;

import java.sql.Connection;

public interface IDatabaseConnection {
    Connection getDatabaseConnection() throws Exception;
    void clearDatabaseConnection();
}

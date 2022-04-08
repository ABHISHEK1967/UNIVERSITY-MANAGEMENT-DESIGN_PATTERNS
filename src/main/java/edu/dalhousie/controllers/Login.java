package edu.dalhousie.controllers;

import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Hashing;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    private IDatabaseConnection IDatabaseConnection;

    public Login(){
        this.IDatabaseConnection = DatabaseConnectivity.getInstance();

    }
    public static String[] getUserLoginDetails() {
        Hashing performHashing = new Hashing();
        System.out.print("Enter your Username: ");
        Scanner enterusername = new Scanner(System.in);
        String username = enterusername.nextLine();

        System.out.print("Enter your Password: ");
        Scanner enterpassword = new Scanner(System.in);
        String userpassword = enterpassword.nextLine();

        String hashedpassword = performHashing.doPasswordHashing(userpassword);

        String[] input = new String[2];
        input[0] = username;
        input[1] = hashedpassword;
        return input;
    }

    public User loginUser(String typeOfLogIn) throws Exception {
        String title = typeOfLogIn.equals("STUDENT") ? "LogIn as a STUDENT" : "LogIn as a FACULTY";
        final Connection connection =
                IDatabaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
        String SQL = "SELECT * FROM users u INNER JOIN " +
                "membership_details md on md.member_id = u.id";
        ResultSet rs = statement.executeQuery(SQL);

        String[] userdetails;
        userdetails = getUserLoginDetails();

        while (rs.next()) {
            String userName = rs.getString("user_name");
            String userPassword = rs.getString("password");
            String phoneNumber = rs.getString("contact_number");
            String address = rs.getString("address");
            int balance = rs.getInt("balance");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int userId = rs.getInt("id");
            if (userdetails[0].equals(userName) && userdetails[1].equals(userPassword)) {
                System.out.println("Verifying your credentials. . .");
                System.out.println("Credentials verified. . .");
                System.out.println("\nForwarding you to the main page. . .");

                if (typeOfLogIn.equals("STUDENT")) {

                    return new User.Builder()
                            .setUserId(userId)
                            .setUserName(userName)
                            .setPassword(userPassword)
                            .setAddress(address)
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setPhoneNumber(phoneNumber)
                            .setBalance(balance)
                            .build();
                } else {

                }
            } else {
                System.out.println("You have entered the wrong credentials.");
                System.out.println("Please try again.\n");
            }
        }
        return null;
    }

}

package edu.dalhousie.controllers;

import edu.dalhousie.business.dalmembership.controller.subscription.Subscription;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private String address;
    private double balance;
    private String firstName;
    private String lastName;
    private Subscription currentSubscription;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Subscription getCurrentSubscription() {
        return currentSubscription;
    }

    public void setCurrentSubscription(Subscription currentSubscription) {
        this.currentSubscription = currentSubscription;
    }


    private User(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.balance = builder.balance;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;

    }
    public static class Builder {
        public int userId;
        private String userName;
        private String password;
        private String phoneNumber;
        private String address;
        private int balance;
        private String firstName;
        private String lastName;
        private Subscription currentSubscription;

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setBalance(int balance) {
            this.balance = balance;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setSubscription(Subscription subscription) {
            this.currentSubscription = subscription;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

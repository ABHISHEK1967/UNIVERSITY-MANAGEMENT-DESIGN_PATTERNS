package edu.dalhousie.business.dalmembership.controller.subscription;

public interface ISubscription {
    double calculatePercentage(double obtained, double total);

    double calculateDiscount(Double charge, Double duration);

    double applyDiscount(double subscriptionAmount, double discount);

}

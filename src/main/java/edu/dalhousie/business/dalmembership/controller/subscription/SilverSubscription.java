package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.business.dalmembership.model.ServicesModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

public class SilverSubscription extends Subscription implements ISubscription{
    public final static double MONTHLY_CHARGES = 5;
    public final static String note = MONTHLY_CHARGES + " CAD will be added as monthly charges";
    private final String SUBSCRIPTION_NAME = "SILVER";
    private List<ServicesModel> services = Arrays.asList(
            new ServicesModel("sports",0),
            new ServicesModel("swimming",0));
    private Set<ServicesModel> basicServices = new HashSet<>(services);
    private double discount;
    private double duration;
    private double subscriptionAmount;
    private double amountAfterDiscount;

    public SilverSubscription(){
        super.subscriptionName = SUBSCRIPTION_NAME;
        super.note = note;
    }
    @Override
    public double calculateCharges() {
        return basicServices.stream().mapToDouble(x-> x.getCharges()).sum();
    }

    @Override
    public Double getMonthlyCharges() {
        return MONTHLY_CHARGES;
    }

    @Override
    public void initializeBasicSubscription() {
        super.addServices(services);
    }

    @Override
    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }


    @Override
    public BiPredicate<Double, Double> checkEligibility() {
        return (durationInMonths,balance)->{
            this.duration = durationInMonths;
            this.discount = calculateDiscount(MONTHLY_CHARGES,duration);
            this.subscriptionAmount = MONTHLY_CHARGES * this.duration;
            this.amountAfterDiscount = applyDiscount(this.subscriptionAmount,this.discount);
            setTotalAmount(this.amountAfterDiscount);
            if (amountAfterDiscount > balance) {
                return false;
            }
            return true;
        };
    }
}

package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.business.dalmembership.model.ServicesModel;
import java.util.Collection;

public abstract class SubscriptionDecorator extends Subscription{
    Subscription subscription = null;

    public SubscriptionDecorator(Subscription subscription){
        this.subscription = subscription;
        Clone(this.subscription);
    }

    void Clone(Subscription subscription) {
        super.totalAmount = subscription.totalAmount;
        super.note = subscription.note;
        super.subscriptionName = subscription.subscriptionName;
        super.totalAmount = subscription.getTotalAmount();
        super.addServices(subscription.getServicesList());
    }

    @Override
    public void setTotalAmount(double amount) {
        super.totalAmount = amount;
    }

    @Override
    public void addServices(Collection<ServicesModel> services) {
        super.addServices(services);
    }
}

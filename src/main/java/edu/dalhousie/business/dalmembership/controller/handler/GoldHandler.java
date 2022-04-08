package edu.dalhousie.business.dalmembership.controller.handler;

import edu.dalhousie.business.dalmembership.controller.subscription.GoldSubscription;
import edu.dalhousie.business.dalmembership.controller.subscription.Subscription;

public class GoldHandler extends Handler{
    private Handler handler;
    @Override
    public Handler nextHandler() {
        this.handler = new SilverHandler();
        return handler;
    }

    @Override
    public Subscription processNextRequest(String choice) throws Exception {
        if ("gold".equalsIgnoreCase(choice)) {
            return new GoldSubscription();
        }
        return this.nextHandler().processNextRequest(choice);
    }
}

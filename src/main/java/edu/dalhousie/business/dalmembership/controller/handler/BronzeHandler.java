package edu.dalhousie.business.dalmembership.controller.handler;

import edu.dalhousie.business.dalmembership.controller.subscription.BronzeSubscription;
import edu.dalhousie.business.dalmembership.controller.subscription.Subscription;

public class BronzeHandler extends Handler{
    private Handler handler;
    @Override
    public Handler nextHandler() {
         this.handler = new GoldHandler();
        return handler;
    }

    @Override
    public Subscription processNextRequest(String choice) throws Exception {
        if ("bronze".equalsIgnoreCase(choice)) {
            return new BronzeSubscription();
        }
        return this.nextHandler().processNextRequest(choice);
    }
}

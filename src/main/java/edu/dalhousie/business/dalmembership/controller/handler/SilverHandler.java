package edu.dalhousie.business.dalmembership.controller.handler;

import edu.dalhousie.business.dalmembership.controller.subscription.SilverSubscription;
import edu.dalhousie.business.dalmembership.controller.subscription.Subscription;

public class SilverHandler extends Handler{
    private Handler handler;
    @Override
    public Handler nextHandler() {
       return null;
    }

    @Override
    public Subscription processNextRequest(String choice) throws Exception {
        if ("silver".equalsIgnoreCase(choice)) {
            return new SilverSubscription();
        }
        return this.nextHandler().processNextRequest(choice);
    }
}

package edu.dalhousie.business.dalmembership.controller.handler;

import edu.dalhousie.business.dalmembership.controller.subscription.Subscription;

public abstract class Handler {
    public abstract Handler nextHandler();
    public abstract Subscription processNextRequest(String choice) throws Exception;
}

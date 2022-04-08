package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.controllers.User;
import edu.dalhousie.database.IDatabaseConnection;

public interface ISubscriptionImplmentation {
    Subscription subscribe(String choice,
                           Double duration,
                           User user,
                           IDatabaseConnection IDatabaseConnection) throws Exception;
}

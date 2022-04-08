/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.state;

public interface State {
    public void performStateTransition(StateContext stateContext);
}

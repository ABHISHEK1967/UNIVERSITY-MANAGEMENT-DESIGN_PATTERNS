/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.state;

public class StateContext {
    private State state = null;
    public void setState(State state) {
        this.state = state;
    }
    public State getState(){
        return state;
    }
}
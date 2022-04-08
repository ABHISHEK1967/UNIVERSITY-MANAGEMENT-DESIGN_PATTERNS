/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.state;

import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class StateAtEnd implements State{
    public ICommonPrinting studentView;

    public StateAtEnd(){
        this.studentView = CommonPrinting.getInstance();
    }

    @Override
    public void performStateTransition(StateContext stateContext) {
        if (stateContext == null) {
            stateContext = new StateContext();
        }
        this.studentView.showMessage("Event ends");
        stateContext.setState(this);
    }
}

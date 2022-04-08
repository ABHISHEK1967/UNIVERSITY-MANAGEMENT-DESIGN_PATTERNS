/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.state;

import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class StateAtStart implements State{
    public ICommonPrinting studentView;

    public StateAtStart(){
        this.studentView = CommonPrinting.getInstance();
    }
    @Override
    public void performStateTransition(StateContext stateContext) {
        if (stateContext == null) {
            stateContext = new StateContext();
        }
        this.studentView.showMessage("Event starts");
        stateContext.setState(this);
    }
}

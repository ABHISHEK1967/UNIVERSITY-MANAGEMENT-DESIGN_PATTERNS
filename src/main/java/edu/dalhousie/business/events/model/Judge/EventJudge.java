/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.model.Judge;

import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class EventJudge {
    public ICommonPrinting studentView;
    private String judgeName;

    public EventJudge(){
        this.studentView = CommonPrinting.getInstance();
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName() {
        this.studentView.showMessage("Enter judge name:");
        this.judgeName = this.studentView.getString();
    }



}

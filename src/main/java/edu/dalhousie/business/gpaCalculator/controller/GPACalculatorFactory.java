package edu.dalhousie.business.gpaCalculator.controller;

import edu.dalhousie.business.gpaCalculator.model.GPACalculatorModel;
import edu.dalhousie.business.gpaCalculator.model.IGPACalculatorModel;

public class GPACalculatorFactory {

    private static GPACalculatorFactory gpaCalculatorFactory = null;

    IGPACalculatorModel gpaCalculatorModel;;

    public GPACalculatorFactory(){
        gpaCalculatorModel = new GPACalculatorModel();
    }

    public static GPACalculatorFactory initialize() {
        if (gpaCalculatorFactory == null) {
            gpaCalculatorFactory = new GPACalculatorFactory();
        }
        return gpaCalculatorFactory;
    }

    public IGPACalculatorModel getGpaCalculatorModel() {
        return gpaCalculatorModel;
    }
}

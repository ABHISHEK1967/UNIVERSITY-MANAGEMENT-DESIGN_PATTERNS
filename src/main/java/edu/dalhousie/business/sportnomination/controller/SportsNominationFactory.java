package edu.dalhousie.business.sportnomination.controller;

import edu.dalhousie.business.sportnomination.model.ISportsNominationModel;
import edu.dalhousie.business.sportnomination.model.SportsNominationModel;

public class SportsNominationFactory {
    private static SportsNominationFactory sportsNominationFactory = null;
    ISportsNominationModel sportsNominationModel;

    public SportsNominationFactory(){
        sportsNominationModel = new SportsNominationModel();
    }

    public static SportsNominationFactory initialize() {
        if (sportsNominationFactory == null) {
            sportsNominationFactory = new SportsNominationFactory();
        }
        return sportsNominationFactory;
    }

    public ISportsNominationModel getSportsNominationModel() {
        return sportsNominationModel;
    }
}

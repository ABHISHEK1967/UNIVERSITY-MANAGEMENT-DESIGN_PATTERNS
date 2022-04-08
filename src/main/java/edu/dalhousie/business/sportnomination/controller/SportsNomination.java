package edu.dalhousie.business.sportnomination.controller;

import edu.dalhousie.business.sportnomination.constants.SportsNominationConstants;
import edu.dalhousie.business.sportnomination.model.ISportsNominationModel;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.printing.PrintHeading;

import java.util.Calendar;

public class SportsNomination implements ISportsNomination
{
    ICommonPrinting view = CommonPrinting.getInstance();
    StudentMainClass studentMenu;
    ISportsNominationModel sportsNominationModel = SportsNominationFactory.initialize().getSportsNominationModel();

    public SportsNomination()
    {
        studentMenu = StudentMainClass.getInstance();
    }

    public String sportsNominationChecker()
    {
        int overallScore = 0;

        view.showMessage(SportsNominationConstants.enterUsername);
        sportsNominationModel.setUsername(view.getString());

        view.showMessage(SportsNominationConstants.enterSportName);
        sportsNominationModel.setSport(view.getString());

        view.showMessage(SportsNominationConstants.enterAwards);
        sportsNominationModel.setAwards(view.getInt());

        view.showMessage(SportsNominationConstants.enterAchievement);
        sportsNominationModel.setAchievementLevel(view.getInt());

        view.showMessage(SportsNominationConstants.enterMedal);
        sportsNominationModel.setMedal(view.getInt());

        view.showMessage(SportsNominationConstants.enterYear);
        sportsNominationModel.setYear(view.getInt());

        view.showMessage(SportsNominationConstants.checkingEligibility);

        sportsNominationModel.setMaxGapYear(2016);
        if (sportsNominationModel.getYear() <= sportsNominationModel.getMaxGapYear())
        {
            view.showMessage(SportsNominationConstants.notEligibleGap);
            //goBack();
        }
        else
        {
            if(sportsNominationModel.getAwards() > 6)
            {
                overallScore += 10;
            }
            else
            {
                overallScore += sportsNominationModel.getAwards();
            }

            sportsNominationModel.setLevelZero(0);
            sportsNominationModel.setLevelOne(1);
            sportsNominationModel.setLevelTwo(2);
            sportsNominationModel.setLevelThree(3);
            sportsNominationModel.setLevelFour(4);

            if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelZero())
            {
                overallScore += sportsNominationModel.getLevelZero();
            }
            else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelOne())
            {
                overallScore += 8;
            }else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelTwo())
            {
                overallScore += 6;
            }else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelThree())
            {
                overallScore += 4;
            }else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelFour())
            {
                overallScore += 2;
            }

            if (sportsNominationModel.getMedal() == sportsNominationModel.getLevelZero())
            {
                overallScore += sportsNominationModel.getLevelZero();
            }
            else if(sportsNominationModel.getMedal() == sportsNominationModel.getLevelOne())
            {
                overallScore += 6;
            }else if(sportsNominationModel.getMedal() == sportsNominationModel.getLevelTwo())
            {
                overallScore += 4;
            }else if(sportsNominationModel.getMedal() == sportsNominationModel.getLevelThree())
            {
                overallScore += 2;
            }

            sportsNominationModel.setCurrentYear(Calendar.getInstance().get(Calendar.YEAR));
            sportsNominationModel.setYearPoints(sportsNominationModel.getCurrentYear()-sportsNominationModel.getYear());
            overallScore -= sportsNominationModel.getYearPoints();

        }

        if(overallScore >= 10)
        {
            view.showMessage(SportsNominationConstants.eligibilityCheck + sportsNominationModel.getUsername() + SportsNominationConstants.eligibilityResult + sportsNominationModel.getSport() + SportsNominationConstants.eligibleClub);
            return SportsNominationConstants.eligibilityCheck + sportsNominationModel.getUsername() + SportsNominationConstants.eligibilityResult + sportsNominationModel.getSport() + SportsNominationConstants.eligibleClub;
        }
        else
        {
            view.showMessage(SportsNominationConstants.notEligible);
            return SportsNominationConstants.notEligible;
        }
    }

    public void viewSportsNomination()
    {
        PrintHeading.printHeadingForTheScreen(SportsNominationConstants.sportsNominationTitle, 38);
        sportsNominationChecker();
    }

}

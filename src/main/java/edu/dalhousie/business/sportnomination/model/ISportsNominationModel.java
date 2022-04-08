package edu.dalhousie.business.sportnomination.model;

public interface ISportsNominationModel {

    public String getUsername();

    public void setUsername(String username);

    public String getSport();

    public void setSport(String sport);

    public int getAwards();

    public void setAwards(int awards);

    public int getAchievementLevel();

    public void setAchievementLevel(int achievementLevel);

    public int getMedal();

    public void setMedal(int medal);

    public int getYear();

    public void setYear(int year);

    public int getMaxGapYear();

    public void setMaxGapYear(int maxGapYear);

    public int getCurrentYear();

    public void setCurrentYear(int currentYear);

    public int getYearPoints();

    public void setYearPoints(int yearPoints);

    public int getLevelZero();

    public void setLevelZero(int levelZero);

    public int getLevelOne();

    public void setLevelOne(int levelOne);

    public int getLevelTwo();

    public void setLevelTwo(int levelTwo);

    public int getLevelThree();

    public void setLevelThree(int levelThree);

    public int getLevelFour();

    public void setLevelFour(int levelFour);
}

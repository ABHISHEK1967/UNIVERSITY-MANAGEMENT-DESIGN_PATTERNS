package edu.dalhousie.business.sportnomination.model;

public class SportsNominationModel implements ISportsNominationModel
{
    private String username;
    private String sport;
    private int awards;
    private int achievementLevel;
    private int medal;
    private int year;
    private int maxGapYear;
    private int currentYear;
    private int yearPoints;
    private int levelZero;
    private int levelOne;
    private int levelTwo;
    private int levelThree;
    private int levelFour;

    public SportsNominationModel() {
    }

    public SportsNominationModel(String username, String sport, int awards, int achievementLevel, int medal, int year, int maxGapYear, int currentYear, int yearPoints, int levelZero, int levelOne, int levelTwo, int levelThree, int levelFour) {
        this.username = username;
        this.sport = sport;
        this.awards = awards;
        this.achievementLevel = achievementLevel;
        this.medal = medal;
        this.year = year;
        this.maxGapYear = maxGapYear;
        this.currentYear = currentYear;
        this.yearPoints = yearPoints;
        this.levelZero = levelZero;
        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
        this.levelThree = levelThree;
        this.levelFour = levelFour;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getAwards() {
        return awards;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }

    public int getAchievementLevel() {
        return achievementLevel;
    }

    public void setAchievementLevel(int achievementLevel) {
        this.achievementLevel = achievementLevel;
    }

    public int getMedal() {
        return medal;
    }

    public void setMedal(int medal) {
        this.medal = medal;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMaxGapYear() {
        return maxGapYear;
    }

    public void setMaxGapYear(int maxGapYear) {
        this.maxGapYear = maxGapYear;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getYearPoints() {
        return yearPoints;
    }

    public void setYearPoints(int yearPoints) {
        this.yearPoints = yearPoints;
    }

    public int getLevelZero() {
        return levelZero;
    }

    public void setLevelZero(int levelZero) {
        this.levelZero = levelZero;
    }

    public int getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(int levelOne) {
        this.levelOne = levelOne;
    }

    public int getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(int levelTwo) {
        this.levelTwo = levelTwo;
    }

    public int getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(int levelThree) {
        this.levelThree = levelThree;
    }

    public int getLevelFour() {
        return levelFour;
    }

    public void setLevelFour(int levelFour) {
        this.levelFour = levelFour;
    }
}

package edu.dalhousie.business.gpaCalculator.model;

public class GPACalculatorModel implements IGPACalculatorModel{
    private double totalPoints;
    private int totalCredits;
    private int credits;
    private String subjectCredits;
    private double gradeValue;
    private String grade;
    private double points;
    private String pattern;
    private double overallGPA;

    public GPACalculatorModel() {
    }

    public GPACalculatorModel(double totalPoints, int totalCredits, int credits, String subjectCredits, double gradeValue, String grade, double points, String pattern, double overallGPA) {
        this.totalPoints = totalPoints;
        this.totalCredits = totalCredits;
        this.credits = credits;
        this.subjectCredits = subjectCredits;
        this.gradeValue = gradeValue;
        this.grade = grade;
        this.points = points;
        this.pattern = pattern;
        this.overallGPA = overallGPA;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSubjectCredits() {
        return subjectCredits;
    }

    public void setSubjectCredits(String subjectCredits) {
        this.subjectCredits = subjectCredits;
    }

    public double getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public double getOverallGPA() {
        return overallGPA;
    }

    public void setOverallGPA(double overallGPA) {
        this.overallGPA = overallGPA;
    }
}

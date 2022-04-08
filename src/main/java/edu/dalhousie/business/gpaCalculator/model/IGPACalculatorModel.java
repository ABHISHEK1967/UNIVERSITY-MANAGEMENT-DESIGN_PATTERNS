package edu.dalhousie.business.gpaCalculator.model;

public interface IGPACalculatorModel {

    public double getTotalPoints();
    public void setTotalPoints(double totalPoints);
    public int getTotalCredits();
    public void setTotalCredits(int totalCredits);
    public int getCredits();
    public void setCredits(int credits);
    public String getSubjectCredits();
    public void setSubjectCredits(String subjectCredits);
    public double getGradeValue();
    public void setGradeValue(double gradeValue);
    public String getGrade();
    public void setGrade(String grade);
    public double getPoints();
    public void setPoints(double points);
    public String getPattern();
    public void setPattern(String pattern);
    public double getOverallGPA();
    public void setOverallGPA(double overallGPA);

}

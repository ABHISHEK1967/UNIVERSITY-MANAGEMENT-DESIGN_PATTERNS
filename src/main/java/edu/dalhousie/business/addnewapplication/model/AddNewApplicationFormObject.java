package edu.dalhousie.business.addnewapplication.model;

public class AddNewApplicationFormObject {

    String course;
    String university;
    String education;
    String gpa;
    String tenthMarks;
    String twelfthMarks;
    String IELTS;
    String GRE;
    String researchPapers;
    String workExp;
    String GMAT;
    String GATE;
    String score;


    public AddNewApplicationFormObject() {
    }

    public AddNewApplicationFormObject(String course, String university, String education, String gpa, String tenthMarks, String twelfthMarks, String IELTS, String GRE, String researchPapers, String workExp, String GMAT, String GATE) {
        this.course = course;
        this.university = university;
        this.education = education;
        this.gpa = gpa;
        this.tenthMarks = tenthMarks;
        this.twelfthMarks = twelfthMarks;
        this.IELTS = IELTS;
        this.GRE = GRE;
        this.researchPapers = researchPapers;
        this.workExp = workExp;
        this.GMAT = GMAT;
        this.GATE = GATE;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getTenthMarks() {
        return tenthMarks;
    }

    public void setTenthMarks(String tenthMarks) {
        this.tenthMarks = tenthMarks;
    }

    public String getTwelfthMarks() {
        return twelfthMarks;
    }

    public void setTwelfthMarks(String twelfthMarks) {
        this.twelfthMarks = twelfthMarks;
    }

    public String getIELTS() {
        return IELTS;
    }

    public void setIELTS(String IELTS) {
        this.IELTS = IELTS;
    }

    public String getGRE() {
        return GRE;
    }

    public void setGRE(String GRE) {
        this.GRE = GRE;
    }

    public String getResearchPapers() {
        return researchPapers;
    }

    public void setResearchPapers(String researchPapers) {
        this.researchPapers = researchPapers;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getGMAT() {
        return GMAT;
    }

    public void setGMAT(String GMAT) {
        this.GMAT = GMAT;
    }

    public String getGATE() {
        return GATE;
    }

    public void setGATE(String GATE) {
        this.GATE = GATE;
    }

    public String getResult() {
        return score;
    }

    public void setResult(String score) {
        this.score = score;
    }

}

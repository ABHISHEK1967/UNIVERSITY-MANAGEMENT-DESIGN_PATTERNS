package edu.dalhousie.business.scholarship.controller;

import edu.dalhousie.controllers.StudentMainClass;

public enum EScholarshipMenuOptions {
    N1(1) {
        @Override
        public void displayScholarshipMenu() throws Exception {
            Scholarship scholarship = new Scholarship();
            scholarship.enterDetailsMenu();
        }

    }, N2(2) {
        @Override
        public void displayScholarshipMenu() throws Exception {
            StudentMainClass studentMainClass = StudentMainClass.getInstance();
            studentMainClass.displayStudentMenu();
        }

    };


    public abstract void displayScholarshipMenu() throws Exception;

    private int value;

    EScholarshipMenuOptions(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}

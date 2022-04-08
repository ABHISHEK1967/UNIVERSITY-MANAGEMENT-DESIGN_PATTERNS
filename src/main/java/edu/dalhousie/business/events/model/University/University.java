/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.model.University;

import edu.dalhousie.business.events.model.Student.Student;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.util.ArrayList;
import java.util.Iterator;

public class University {
    public String universityName;
    protected UniversityDetails universityDetails;
    public ICommonPrinting studentView;
    public ArrayList<String> University = new ArrayList<>();

    public University(String universityName){
        this.universityName = universityName;
        this.universityDetails = new UniversityDetails();
        University.add(universityName);
        studentView = CommonPrinting.getInstance();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void studentInfo(){

        Iterator<Student> itr= this.universityDetails.Iterator();
        this.studentView.showMessage("Student List:");
        while(itr.hasNext())
        {
            this.studentView.showMessage(itr.next().getUserName());
        }
    }
}

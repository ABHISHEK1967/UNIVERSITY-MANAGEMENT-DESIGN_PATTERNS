/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.controller.PaymentInformation;

import edu.dalhousie.business.payment.database.PaymentDetails.IPaymentDetailsDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IPaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.model.PaymentDetails;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseException;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import static edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsConstant.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowPaymentInformation implements IPaymentInformation{
    private final IDatabaseConnection IDatabaseConnection;
    private final IPaymentDetailsDAOQueryBuilder IPaymentDetailsDAOQueryBuilder;
    private final IPaymentStatusDAOQueryBuilder paymentStatusDAOQueryBuilder;
    private final ICommonPrinting view;
    UserSession userSession;
    private final int MAXIMUM_CREDITS=12;
    private static ILogger logger;
    public ShowPaymentInformation(IDatabaseConnection IDatabaseConnection,
                                  IPaymentDetailsDAOQueryBuilder
                                          IPaymentDetailsDAOQueryBuilder,
                                  IPaymentStatusDAOQueryBuilder
                                          paymentStatusDAOQueryBuilder){
        this.IDatabaseConnection = IDatabaseConnection;
        this.IPaymentDetailsDAOQueryBuilder = IPaymentDetailsDAOQueryBuilder;
        this.paymentStatusDAOQueryBuilder = paymentStatusDAOQueryBuilder;
        this.view = CommonPrinting.getInstance();
        userSession = UserSession.getInstance();
        logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
    }

    @Override
    public void showFeeDetails() throws DatabaseException {
        int student_id = userSession.getUser().getUserId();
        this.view.showMessage("Enter the term:");
        String term = this.view.getString();
        try{
            final Connection connection =
                    IDatabaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            final ResultSet paymentStatusResultSet =
                    statement.executeQuery(
                            paymentStatusDAOQueryBuilder
                                    .getPaymentStatus(student_id,term));
            String status=null;
            while(paymentStatusResultSet.next()){
                status = paymentStatusResultSet.getString("payment_status");
            }

            if(status==null){
                final ResultSet paymentDetailsResultSet =
                        statement.executeQuery(
                                IPaymentDetailsDAOQueryBuilder
                                        .selectEnrolledCoursesQuery(student_id));
                final List<PaymentDetails> paymentDetailsArrayList =
                        preparePaymentDetails(paymentDetailsResultSet);
                int labCount = 0;
                int theoryCount = 0;
                this.view.showMessage("\nYou have registered in the following courses:");
                for(PaymentDetails paymentDetails: paymentDetailsArrayList){
                    this.view.showMessage(paymentDetails.getCourseId() + " "
                            + paymentDetails.getCourseName());
                    final String courseType = paymentDetails.getCourseType();
                    if (courseType.equalsIgnoreCase("Theory")) {
                        theoryCount++;
                    }
                    else{
                        labCount++;
                    }
                }
                this.view.showMessage("\nMaximum credits: "+ MAXIMUM_CREDITS);
                this.view.showMessage("Total registered courses: " +
                        paymentDetailsArrayList.size());
                int credits = theoryCount * 3;
                this.view.showMessage("Total credits: " + credits);
                int amount = theoryCount * 1500 + labCount * 500;
                this.view.showMessage("Total payable amount: " + amount);
            }
            else{
                if (status.equalsIgnoreCase("full")){
                    this.view.showMessage("You have already paid the " +
                            "fees for the "+term+ " term");
                }else{
                    this.view.showMessage("You have already opted the " +
                            "emi option for the "+term+ " term");
                }
            }

        }
        catch(Exception e){
            logger.error(ShowPaymentInformation.class.toString(),e.getMessage());
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    private List<PaymentDetails> preparePaymentDetails(ResultSet paymentDetailsResultSet)
            throws SQLException {
        final List<PaymentDetails> paymentDetailsArrayList = new ArrayList<>();
        while(paymentDetailsResultSet.next()){
            final int courseId = paymentDetailsResultSet.getInt(COURSE_ID);
            final int studentId = paymentDetailsResultSet.getInt(STUDENT_ID);
            final String courseName = paymentDetailsResultSet.getString(COURSE_NAME);
            final String courseType = paymentDetailsResultSet.getString(COURSE_TYPE);
            PaymentDetails paymentDetails =
                    new PaymentDetails(courseId,studentId,courseName,courseType);
            paymentDetailsArrayList.add(paymentDetails);
        }
        return paymentDetailsArrayList;
    }
}

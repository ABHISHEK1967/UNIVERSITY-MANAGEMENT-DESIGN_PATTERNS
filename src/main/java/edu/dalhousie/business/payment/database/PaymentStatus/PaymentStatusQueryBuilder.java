/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.payment.database.PaymentStatus;

import static edu.dalhousie.business.payment.database.PaymentStatus.PaymentStatusConstant.*;

public class PaymentStatusQueryBuilder implements IPaymentStatusDAOQueryBuilder {
    private static PaymentStatusQueryBuilder paymentStatusQueryBuilder;
    private PaymentStatusQueryBuilder(){

    }

    public static PaymentStatusQueryBuilder getInstance(){
        if(paymentStatusQueryBuilder == null){
            return paymentStatusQueryBuilder = new PaymentStatusQueryBuilder();
        }
        return paymentStatusQueryBuilder;
    }
    @Override
    public String getPaymentStatus(int id, String term) {
        return "SELECT " + PAYMENT_STATUS + "\n" +
                " FROM " + PAYMENT_TABLE + "\n" +
                " WHERE " + STUDENT_ID + " = " + id +
                " and term =" + "'" + term + "'";
    }
}

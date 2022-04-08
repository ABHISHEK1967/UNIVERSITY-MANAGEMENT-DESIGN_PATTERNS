/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.payment.database.PaymentStatus;

public interface IUpdatePaymentStatusDAOQueryBuilder {
    String updatePaymentStatus(int id, String status, String term);
}

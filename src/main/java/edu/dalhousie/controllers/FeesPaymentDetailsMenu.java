/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.controllers;

import edu.dalhousie.business.payment.controller.EMIPayment.EMIPaymentPlans;
import edu.dalhousie.business.payment.controller.FullPayment.FullPayment;
import edu.dalhousie.business.payment.controller.PaymentInformation.ShowPaymentInformation;
import edu.dalhousie.business.payment.database.PaymentDetails.IPaymentDetailsDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IPaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IUpdatePaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.PaymentStatusQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.UpdatePaymentStatusQueryBuilder;
import edu.dalhousie.database.DatabaseException;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class FeesPaymentDetailsMenu {
    private static FeesPaymentDetailsMenu feesPaymentDetailsMenu;
    private final ICommonPrinting view;
    private final StudentMainClass studentMenu;
    private final IDatabaseConnection IDatabaseConnection;
    private final IPaymentDetailsDAOQueryBuilder IPaymentDetailsDAOQueryBuilder;
    private final IPaymentStatusDAOQueryBuilder iPaymentStatusDAOQueryBuilder;
    private final IUpdatePaymentStatusDAOQueryBuilder iUpdatePaymentStatusDAOQueryBuilder;
    private static ILogger logger;

    private FeesPaymentDetailsMenu(){
        this.view = CommonPrinting.getInstance();
        this.studentMenu = StudentMainClass.getInstance();
        IDatabaseConnection = DatabaseConnectivity.getInstance();
        this.IPaymentDetailsDAOQueryBuilder = PaymentDetailsQueryBuilder.getInstance();
        this.iPaymentStatusDAOQueryBuilder = PaymentStatusQueryBuilder.getInstance();
        this.iUpdatePaymentStatusDAOQueryBuilder = UpdatePaymentStatusQueryBuilder.getInstance();
        logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
    }
    public static FeesPaymentDetailsMenu getInstance(){
        if(feesPaymentDetailsMenu == null){
            feesPaymentDetailsMenu = new FeesPaymentDetailsMenu();
        }
        return feesPaymentDetailsMenu;
    }
    protected void showPaymentInformationMenu() {
        this.view.showMessage("**************************************");
        this.view.showMessage("\t \t Fees payment Menu \t");
        this.view.showMessage("**************************************");
        while (true) {
            this.view.showMessage("\nHow Would you like to pay the fees ?" +
                    "(1:Show payment details, 2: Full payment, 3: EMI structure, 4: Exit)");
            int choice = this.view.getInt();
            switch (choice) {
                case 1:
                    ShowPaymentInformation showPaymentInformation =
                            new ShowPaymentInformation(IDatabaseConnection,
                                    IPaymentDetailsDAOQueryBuilder,
                                    iPaymentStatusDAOQueryBuilder);

                    try {
                        showPaymentInformation.showFeeDetails();
                    } catch (DatabaseException e) {
                        e.printStackTrace();
                        logger.error(ShowPaymentInformation.class.toString(),e.getMessage());
                    }

                    break;
                case 2:
                    this.view.showMessage("Full payment");
                    FullPayment fullPayment = new FullPayment(IDatabaseConnection,
                            iUpdatePaymentStatusDAOQueryBuilder);
                    try {
                        fullPayment.deductTotalAmount();
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(ShowPaymentInformation.class.toString(),e.getMessage());
                    }
                    break;
                case 3:
                    this.view.showMessage("EMI");
                    EMIPaymentPlans emiPaymentPlans = new EMIPaymentPlans(
                            IDatabaseConnection,
                            IPaymentDetailsDAOQueryBuilder,
                            iPaymentStatusDAOQueryBuilder,
                            iUpdatePaymentStatusDAOQueryBuilder);

                        emiPaymentPlans.showEMIStructure();

                    break;
                case 4:
                    try {
                        this.studentMenu.displayStudentMenu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(ShowPaymentInformation.class.toString(),e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

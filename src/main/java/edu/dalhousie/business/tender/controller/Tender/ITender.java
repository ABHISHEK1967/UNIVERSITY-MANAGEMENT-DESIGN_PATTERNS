/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.tender.controller.Tender;

import edu.dalhousie.business.tender.model.Auctioneer;

import java.util.Collection;

public interface ITender {
    void setTenderEvent(String tenderEvent);

    void addNewAuctioneers(Collection<Auctioneer> bidders);

    Auctioneer startTender() throws Exception;
}

/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.tender.controller.Tender;

import edu.dalhousie.business.tender.model.Auctioneer;

import java.util.*;

public abstract class AbstractTender implements ITender {
    protected String tenderEvent = null;
    protected Collection<Auctioneer> auctioneers = new HashSet<>();
    Scanner sc = new Scanner(System.in);

    public abstract Auctioneer findBestAuctioneer() throws Exception;

    @Override
    public void setTenderEvent(String tenderEvent) {
        this.tenderEvent = tenderEvent;
    }

    @Override
    public void addNewAuctioneers(Collection<Auctioneer> auctioneers) {
        this.auctioneers.addAll(auctioneers);
    }

    @Override
    public Auctioneer startTender() throws Exception {
        if (tenderEvent == null) {
            throw new Exception("Event is not set and hence tender is canceled.");
        }

        if (auctioneers.size() == 0) {
            throw new Exception("No auctioneers turned up and hence cancelling the auction.");
        }

        Auctioneer winner = findBestAuctioneer();
        System.out.println(winner.getName() + " won auction for " + this.tenderEvent);
        return winner;
    }


}

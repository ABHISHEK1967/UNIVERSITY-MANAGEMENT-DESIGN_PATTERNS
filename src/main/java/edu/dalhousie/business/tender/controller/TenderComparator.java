/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.tender.controller;

import edu.dalhousie.business.tender.model.Auctioneer;

import java.util.Comparator;

public class TenderComparator implements Comparator<Auctioneer> {
    @Override
    public int compare(Auctioneer auctioneer1, Auctioneer auctioneer2) {
        int comparison = auctioneer1.getBidAmount() - auctioneer2.getBidAmount();

        if (comparison == 0) {
            comparison = (int) (auctioneer1.getTimeOfPlacingABid().getTime()
                    - auctioneer2.getTimeOfPlacingABid().getTime());
        }

        return comparison;
    }
}

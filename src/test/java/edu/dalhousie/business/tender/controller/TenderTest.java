/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.tender.controller;

import edu.dalhousie.business.tender.controller.Tender.ITender;
import edu.dalhousie.business.tender.controller.Tender.Tender;
import edu.dalhousie.business.tender.model.Auctioneer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TenderTest {
    private static ITender tender = null;
    private static Collection<Auctioneer> Auctioneers = null;
    private static Tender tenderMock;

    @BeforeAll
    public static void setUp() {
        tender = Tender.getInstance();
        Auctioneers = new ArrayList<>();
        tenderMock = Mockito.mock(Tender.class);
    }

    @Test
    public void auctionTest() throws Exception {
        tender.setTenderEvent("Canteen");

        Auctioneers.add(new Auctioneer("Tim Horton's", 45, 80, 3));
        Auctioneers.add(new Auctioneer("Adda", 25, 82, 2));
        Auctioneers.add(new Auctioneer("Passage to India", 55, 85, 5));

        tender.addNewAuctioneers(Auctioneers);

        Auctioneer winner = tender.startTender();

        Assertions.assertEquals(85, winner.getBidAmount());
        Assertions.assertEquals("Passage to India", winner.getName());
    }

    @Test
    public void getTenderDataTest() {
        try {
            tenderMock.getTenderData();
            verify(tenderMock, times(1)).getTenderData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findBestAuctioneerTest() {

        tenderMock.findBestAuctioneer();
        verify(tenderMock, times(1)).findBestAuctioneer();

    }
}

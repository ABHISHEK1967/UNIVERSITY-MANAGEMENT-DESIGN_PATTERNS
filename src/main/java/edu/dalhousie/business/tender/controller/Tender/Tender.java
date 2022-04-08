/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.tender.controller.Tender;

import edu.dalhousie.business.tender.controller.TenderComparator;
import edu.dalhousie.business.tender.database.ITenderWinnerDAOQueryBuilder;
import edu.dalhousie.business.tender.database.TenderWinnerQueryBuilder;
import edu.dalhousie.business.tender.model.Auctioneer;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

public class Tender extends AbstractTender {
    private static Tender tenderInstance;
    private Tender(){

    }
    public static Tender getInstance(){
        if(tenderInstance==null){
            tenderInstance = new Tender();
        }
        return tenderInstance;
    }

    @Override
    public Auctioneer findBestAuctioneer() {
        Set<Auctioneer> activeAuctioneers = new HashSet<>(auctioneers);
        System.out.println("Starting auction for : " + this.tenderEvent);
        while (activeAuctioneers.size() > 1) {
            Auctioneer lowestAuctioneer = null;

            for (Auctioneer auctioneer : auctioneers) {

                if (!activeAuctioneers.contains(auctioneer)) {
                    continue;
                }

                int nextBid = auctioneer.getBidAmount() + auctioneer.getIncrement();

                if (auctioneer.getMaximumAmount() < nextBid) {
                    activeAuctioneers.remove(auctioneer);
                    continue;
                }

                if (lowestAuctioneer == null ||
                        (nextBid < lowestAuctioneer.getBidAmount()
                                + lowestAuctioneer.getIncrement())) {
                    lowestAuctioneer = auctioneer;
                }
            }

            if (lowestAuctioneer != null) {
                lowestAuctioneer.bid();
            }
        }
        return Collections.max(auctioneers, new TenderComparator());
    }

    public void getTenderData() throws Exception {
        ITenderWinnerDAOQueryBuilder iTenderWinnerDAOQueryBuilder = TenderWinnerQueryBuilder.getInstance();
        IDatabaseConnection IDatabaseConnection = DatabaseConnectivity.getInstance();
        System.out.println("Enter the event name:");
        String eventName = sc.nextLine();
        setTenderEvent(eventName);
        List Auctioneers = new ArrayList<>();
        System.out.println("Enter the number of Auctioneers:");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter Auctioneer name:");
            String auctioneerName = sc.next();
            System.out.println("Enter initial amount:");
            int initialAmount = sc.nextInt();
            System.out.println("Enter maximum amount:");
            int maximumAmount = sc.nextInt();
            System.out.println("Enter incremental amount:");
            int incrementalValueForEachRound = sc.nextInt();
            Auctioneers.add(new Auctioneer(auctioneerName,
                    initialAmount, maximumAmount, incrementalValueForEachRound));
        }
        addNewAuctioneers(Auctioneers);
        Auctioneer winner = startTender();
        String winnerName = winner.getName();
        final Connection connection =
                IDatabaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
        statement.executeUpdate(
                iTenderWinnerDAOQueryBuilder
                        .updateWinner(winnerName));
    }
}

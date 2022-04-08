package edu.dalhousie.business.tender.controller;


import edu.dalhousie.business.tender.controller.TenderComparator;
import edu.dalhousie.business.tender.model.Auctioneer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TenderComparatorTest {

    private  static TenderComparator tenderComparator;
    private  static TenderComparator tenderComparatorMock;

    @BeforeAll
    public static void setUp() {
        tenderComparator = new TenderComparator();
        tenderComparatorMock = Mockito.mock(TenderComparator.class);
    }

    @Test
    public void compareTest(){
        Auctioneer auctioneer1 = new Auctioneer("Tim Horton's", 45, 80, 3);
        Auctioneer auctioneer2 = new Auctioneer("Adda", 25, 82, 2);
        int result = tenderComparator.compare(auctioneer1,auctioneer2);
        Assertions.assertEquals(result,20);
    }

    @Test
    public void findBestAuctioneerTest() {
        Auctioneer auctioneer1 = new Auctioneer("Tim Horton's", 45,
                80, 3);
        Auctioneer auctioneer2 = new Auctioneer("Adda", 25,
                82, 2);
        tenderComparatorMock.compare(auctioneer1,auctioneer2);
        verify(tenderComparatorMock, times(1)).compare(auctioneer1,auctioneer2);
    }

}

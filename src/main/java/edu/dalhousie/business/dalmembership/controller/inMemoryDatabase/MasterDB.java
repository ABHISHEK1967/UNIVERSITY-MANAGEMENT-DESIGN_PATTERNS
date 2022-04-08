/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.inMemoryDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MasterDB {
    public static final List<services> bronze_club = new ArrayList<>();
    public static final List<services> gold_club = new ArrayList<>();
    public static final List<services> silver_club = new ArrayList<>();
    public static final Map<membership, List<services>> servicesMap = new ConcurrentHashMap<>();

    static{
        bronze_club.add(services.massage);

        gold_club.add(services.yoga);
        gold_club.add(services.personal_trainer);

        silver_club.add(services.rock_climbing);
        silver_club.add(services.physio);

        servicesMap.put(membership.BRONZE,bronze_club);
        servicesMap.put(membership.SILVER,silver_club);
        servicesMap.put(membership.GOLD,gold_club);
    }


    private final static String[] Menu =
            { "View current balance",
            "Recharge dal card",
            "View AVAILABLE services",
            "Upgrade membership plans",
            "Exit" };

    public static final List<String> menu = new ArrayList<>(Arrays.asList(Menu));


}

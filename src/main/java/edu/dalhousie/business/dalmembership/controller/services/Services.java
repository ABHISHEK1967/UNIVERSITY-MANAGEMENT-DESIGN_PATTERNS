/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.services;

import edu.dalhousie.business.dalmembership.controller.inMemoryDatabase.MasterDB;

public class Services implements IServices{
    @Override
    public void getListOfServices() {
        MasterDB.servicesMap.keySet().forEach(membership->{
            System.out.println("Services available under "
                    + membership.name() +" plan:" );
            System.out.println("===========================");
            MasterDB.servicesMap.get(membership)
                    .forEach(service->
                            System.out.println("Name: "+
                                    service.name() + " price: "+
                                    service.price +" CAD" ));
            System.out.println();
        });
    }
}

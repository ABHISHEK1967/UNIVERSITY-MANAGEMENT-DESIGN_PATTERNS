/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.inMemoryDatabase;

public enum services {
    massage(10),
    physio(20),
    rock_climbing(20),
    yoga(30),
    personal_trainer(100);
    public int price;
    services(int price) {
        this.price = price;
    }
}

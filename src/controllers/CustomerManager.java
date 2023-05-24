package controllers;

import models.Customer;

public class CustomerManager {
    public boolean insert(Customer user) {
        //Receive user info from UI
        //Validate user info
        //Send user info to DB
        //Receive user status from DB
        //Return Login status to UI
        UserJDBC userJDBC = new UserJDBC();
        boolean result = userJDBC.insert(user);
        return result;
    }

}
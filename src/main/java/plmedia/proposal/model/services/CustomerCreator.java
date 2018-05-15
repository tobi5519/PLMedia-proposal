package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.Customer;

public class CustomerCreator {

    public CustomerCreator(){

    }

    public Customer createCustomer(String companyName, String cvr){
        return new Customer(companyName, cvr);
    }
}

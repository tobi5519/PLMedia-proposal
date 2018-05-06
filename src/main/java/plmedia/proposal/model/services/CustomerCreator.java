package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.Customer;

public class CustomerCreator {

    public CustomerCreator(){

    }

    public Customer createCustomer(){
        return new Customer();
    }
}

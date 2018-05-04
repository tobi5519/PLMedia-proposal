package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.*;

public class ProductCreator {

    public ProductCreator(){}

    public Product createProduct(String name, double price, String description){
        return new Product(name, price, description);
    }
}

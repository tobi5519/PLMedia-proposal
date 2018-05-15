package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.*;

public class ProductCreator {

    public ProductCreator(){}

    public Product createProduct(){
        return new Product();
    }

    public Product createProduct(String name, double price, String description){
        return new Product(name, price, description);
    }

    public Product createProduct(int id, String name, double price, String description){
        return new Product(id, name, price, description);
    }
}

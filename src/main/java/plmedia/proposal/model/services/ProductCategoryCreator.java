package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.ProductCategory;

public class ProductCategoryCreator {

    public ProductCategoryCreator(){

    }

    public ProductCategory createProductCategory(){
        return new ProductCategory();
    }
}

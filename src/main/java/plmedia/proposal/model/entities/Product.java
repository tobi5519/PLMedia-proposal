package plmedia.proposal.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true) // unique is not working
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    public Product(){

    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString(){
        return name + " costs " + price + " and is " + description;
    }
}
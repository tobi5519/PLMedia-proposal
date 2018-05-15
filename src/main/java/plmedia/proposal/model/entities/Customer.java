package plmedia.proposal.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "cvr")
    private String cvr;

    @OneToMany
    @JoinTable(name = "company_contact_persons")
    private List<ContactPerson> contactPersons;

    public Customer() {
    }

    public Customer(String companyName, String cvr){
        this.companyName = companyName;
        this.cvr = cvr;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public String toString(){
        return companyName;
    }
}

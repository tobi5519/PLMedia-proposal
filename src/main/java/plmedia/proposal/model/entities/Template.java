package plmedia.proposal.model.entities;

import javax.persistence.*;

@Entity(name = "Template")
@Table(name = "template")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
//    @JoinTable(name = "proposal")
    @PrimaryKeyJoinColumn(name = "proposal")
    private Proposal proposal;

    public Template() {
    }

    public int getId() {
        return id;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public String toString(){
        return "Template id: " + id;
    }
}
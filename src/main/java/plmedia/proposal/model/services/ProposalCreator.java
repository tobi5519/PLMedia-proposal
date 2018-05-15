package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.Proposal;

public class ProposalCreator {

    public ProposalCreator(){

    }

    public Proposal createProposal(double discount){
        return new Proposal(discount);
    }
}

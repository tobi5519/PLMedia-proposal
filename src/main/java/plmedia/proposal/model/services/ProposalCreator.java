package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.Proposal;

public class ProposalCreator {

    public ProposalCreator(){

    }

    public Proposal createProposal(){
        return new Proposal();
    }
}

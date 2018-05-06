package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.ContactPerson;

public class ContactPersonCreator {

    public ContactPersonCreator(){
    }

    public ContactPerson createContactPerson(){
        return new ContactPerson();
    }
}

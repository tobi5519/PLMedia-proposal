package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.ContactPerson;

public class ContactPersonCreator {

    public ContactPersonCreator(){
    }

    public ContactPerson createContactPerson(String name, String email, String phoneNumber){
        return new ContactPerson(name, email, phoneNumber);
    }
}

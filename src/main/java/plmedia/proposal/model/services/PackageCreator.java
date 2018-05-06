package plmedia.proposal.model.services;

import plmedia.proposal.model.entities.Package;

public class PackageCreator {

    public PackageCreator(){

    }

    public Package createPackage(){
        return new Package();
    }
}

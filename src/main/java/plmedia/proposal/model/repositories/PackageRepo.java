package plmedia.proposal.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plmedia.proposal.model.entities.Package;

public interface PackageRepo extends JpaRepository<Package, Integer> {

}

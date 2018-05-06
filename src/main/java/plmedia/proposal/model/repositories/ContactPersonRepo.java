package plmedia.proposal.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plmedia.proposal.model.entities.ContactPerson;

public interface ContactPersonRepo extends JpaRepository<ContactPerson, Integer> {

}

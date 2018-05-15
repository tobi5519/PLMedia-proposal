package plmedia.proposal.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plmedia.proposal.model.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}

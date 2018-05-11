package plmedia.proposal.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plmedia.proposal.model.entities.Proposal;

import java.util.List;

public interface ProposalRepo extends JpaRepository<Proposal, Integer> {
    List<Proposal> findAll();
}

package plmedia.proposal.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plmedia.proposal.model.entities.Proposal;

import java.sql.Date;
import java.util.List;

public interface ProposalRepo extends JpaRepository<Proposal, Integer> {
    List<Proposal> findAll();
    List<Proposal> findAllByAcceptDateIsNotNull();
    List<Proposal> findAllByAcceptDateIsNull();
    List<Proposal> findAllBySendDateBetween(Date fromDate, Date toDate);
    List<Proposal> findAllByAcceptDateIsNotNullAndSendDateIsBetween(Date fromDate, Date toDate);
    List<Proposal> findAllByAcceptDateIsNullAndSendDateIsBetween(Date fromDate, Date toDate);
    List<Proposal> findAllByCustomerCompanyName(String companyName);
    List<Proposal> findAllByCustomer_Cvr(String cvr);
    List<Proposal> findAllByCustomerContactPersonsEmail(String email);
    Proposal findById(int id);

}

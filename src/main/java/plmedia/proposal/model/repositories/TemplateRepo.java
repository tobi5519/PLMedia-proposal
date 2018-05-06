package plmedia.proposal.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plmedia.proposal.model.entities.Template;

public interface TemplateRepo extends JpaRepository<Template, Integer> {
}

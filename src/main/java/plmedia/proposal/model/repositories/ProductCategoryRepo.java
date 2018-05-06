package plmedia.proposal.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plmedia.proposal.model.entities.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {
}

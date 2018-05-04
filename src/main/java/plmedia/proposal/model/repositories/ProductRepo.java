package plmedia.proposal.model.repositories;

import plmedia.proposal.model.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    Product findById(int id);
}

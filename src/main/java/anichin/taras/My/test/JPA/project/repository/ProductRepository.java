package anichin.taras.My.test.JPA.project.repository;

import anichin.taras.My.test.JPA.project.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {
  @Query("select  p from Product p where p.customer.id=?1")
  List<Product> findAllProductsForConcreteCustomer(Long id);
}
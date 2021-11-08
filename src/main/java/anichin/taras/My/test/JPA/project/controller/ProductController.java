package anichin.taras.My.test.JPA.project.controller;
import anichin.taras.My.test.JPA.project.entities.Product;
import anichin.taras.My.test.JPA.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

  private final ProductRepository productRepository;

  @Autowired
  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostMapping("/saveProduct")
  public Product saveProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  @GetMapping("/findAllProduct")
  public List <Product> findAll() {
    return productRepository.findAll();
  }

  @GetMapping("/findallproduct/{id}")
  public List<Product> findAllProductsForCustomer(@PathVariable Long id) {
    return productRepository.findAllProductsForConcreteCustomer(id);
  }
}

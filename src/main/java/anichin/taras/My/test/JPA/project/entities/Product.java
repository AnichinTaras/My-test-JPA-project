package anichin.taras.My.test.JPA.project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Table(name="product", schema="jpa_buddy")
@Entity
@NoArgsConstructor
@ToString
public class Product {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", nullable=false)
  private Long id;
  @Column(name="product_name", nullable=false)
  private String product_name;

  @Column(name="price", nullable=false)
  private Double price;

  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="customer_id")
  @JsonBackReference
  private Customer customer;

  public Product(String product_name, Double price, Customer customer) {
    this.product_name=product_name;
    this.price=price;
    this.customer = customer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id=id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name=product_name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price=price;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer=customer;
  }

}
package anichin.taras.My.test.JPA.project.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name="customer", schema="jpa_buddy")
@Entity
@NoArgsConstructor
@ToString
public class  Customer {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", nullable=false)
  private Long id;

  @Column(name="customer_name", nullable=false)
  private String customerName;

  @Temporal(TemporalType.DATE)
  @Column(name="birth_date", nullable=false)
  private Date birth;

  @OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
  @JsonManagedReference
  @ToString.Exclude
  private List <Product> products = new ArrayList <>();

  public Customer(String customerName, Date birth) {
    this.customerName=customerName;
    this.birth=birth;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id=id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName=customerName;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth=birth;
  }

  public List <Product> getProducts() {
    return products;
  }

  public void setProducts(List <Product> products) {
    this.products=products;
  }

}
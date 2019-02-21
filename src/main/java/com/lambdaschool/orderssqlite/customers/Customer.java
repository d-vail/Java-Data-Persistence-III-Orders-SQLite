package com.lambdaschool.orderssqlite.customers;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lambdaschool.orderssqlite.agents.Agent;
import com.lambdaschool.orderssqlite.orders.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer table modeled after the sample database found on W3Resource.
 *
 * @see <a href="https://www.w3resource.com/sql/sql-table.php">W3Resource Sample Database</a>
 */
@Data
@Entity
@Table(name = "Customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CustomerCode", nullable = false)
  private long customerCode;

  @Column(name = "CustomerName", nullable = false)
  private String customerName;

  @Column(name = "CustomerCity")
  private String customerCity;

  @Column(name = "WorkingArea", nullable = false)
  private String workingArea;

  @Column(name = "CustomerCountry", nullable = false)
  private String customerCountry;

  @Column(name = "Grade")
  private String grade;

  @Column(name = "OpeningAmount", nullable = false)
  private double openingAmount;

  @Column(name = "ReceiveAmount", nullable = false)
  private double receiveAmount;

  @Column(name = "PaymentAmount", nullable = false)
  private double paymentAmount;

  @Column(name = "OutstandingAmount", nullable = false)
  private double outstandingAmount;

  @Column(name = "Phone", nullable = false)
  private String phone;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "AgentCode", nullable = false)
  private Agent agent;

  @JsonManagedReference
  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
  private Set<Order> orders = new HashSet<>();

  /**
   * Default Constructor
   */
  public Customer() { }
}

package com.lambdaschool.orderssqlite.orders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lambdaschool.orderssqlite.agents.Agent;
import com.lambdaschool.orderssqlite.customers.Customer;
import lombok.Data;

import javax.persistence.*;

/**
 * Orders table modeled after the sample database found on W3Resource.
 *
 * @see <a href="https://www.w3resource.com/sql/sql-table.php">W3Resource Sample Database</a>
 */
@Data
@Entity
@Table(name = "Orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "OrderNumber", nullable = false)
  private long orderNumber;

  @Column(name = "OrderAmount", nullable = false)
  private double orderAmount;

  @Column(name = "AdvanceAmount", nullable = false)
  private double advanceAmount;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "CustomerCode", nullable = false)
  private Customer customer;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "AgentCode", nullable = false)
  private Agent agent;

  @Column(name = "OrderDescription", nullable = false)
  private String orderDescription;

  /**
   * Default Constructor
   */
  public Order() { }
}

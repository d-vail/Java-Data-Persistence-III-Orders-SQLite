package com.lambdaschool.orderssqlite.agents;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lambdaschool.orderssqlite.customers.Customer;
import com.lambdaschool.orderssqlite.orders.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Agent table modeled after the sample database found on W3Resource.
 *
 * @see <a href="https://www.w3resource.com/sql/sql-table.php">W3Resource Sample Database</a>
 */
@Data
@Entity
@Table(name = "Agent")
public class Agent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "AgentCode", nullable = false)
  private long agentCode;

  @Column(name = "AgentName")
  private String agentName;

  @Column(name = "WorkingArea")
  private String workingArea;

  @Column(name = "Commission")
  private double commission;

  @Column(name = "Phone")
  private String phone;

  @Column(name = "Country")
  private String country;

  @JsonManagedReference
  @OneToMany(mappedBy = "agent")
  private Set<Customer> customers = new HashSet<>();

  @JsonManagedReference
  @OneToMany(mappedBy = "agent")
  private Set<Order> orders = new HashSet<>();

  /**
   * Default Constructor
   */
  public Agent() { }
}

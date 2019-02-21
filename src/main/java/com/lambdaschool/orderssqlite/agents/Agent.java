package com.lambdaschool.orderssqlite.agents;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lambdaschool.orderssqlite.customers.Customer;
import com.lambdaschool.orderssqlite.orders.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * AGENT table modeled after the sample database found on W3Resource.
 *
 * @see <a href="https://www.w3resource.com/sql/sql-table.php">W3Resource Sample Database</a>
 */
@Entity
@Table(name = "AGENTS")
public class Agent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "AGENT_CODE", nullable = false)
  private long agentCode;

  @Column(name = "AGENT_NAME")
  private String agentName;

  @Column(name = "WORKING_AREA")
  private String workingArea;

  @Column(name = "COMMISSION")
  private double commission;

  @Column(name = "PHONE_NO")
  private String phone;

  @Column(name = "COUNTRY")
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

  /**
   * Getter for the agent code.
   *
   * @return  The AGENT_CODE stored in table AGENT
   */
  public long getAgentCode() {
    return agentCode;
  }

  /**
   * Getter for the agent name.
   *
   * @return  The AGENT_NAME stored in table AGENT
   */
  public String getAgentName() {
    return agentName;
  }

  /**
   * Setter for the agent name.
   *
   * @param agentName The name of the agent
   */
  public void setAgentName(String agentName) {
    this.agentName = agentName;
  }

  /**
   * Getter for the agent's working area.
   *
   * @return  The WORKING_AREA stored in the table AGENT
   */
  public String getWorkingArea() {
    return workingArea;
  }

  /**
   * Setter for the agent's working area.
   *
   * @param workingArea The agent's working area
   */
  public void setWorkingArea(String workingArea) {
    this.workingArea = workingArea;
  }

  /**
   * Getter for the agent's commision.
   *
   * @return  The COMMISSION stored in the table AGENT
   */
  public double getCommission() {
    return commission;
  }

  /**
   * Setter for the agent's commission.
   *
   * @param commission  The agent's commission
   */
  public void setCommission(double commission) {
    this.commission = commission;
  }

  /**
   * Getter for the agent's phone number.
   *
   * @return  The PHONE_NO stored in the table AGENT
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Setter for the agent's phone number.
   *
   * @param phone The agent's phone number
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Getter for the agent's country.
   *
   * @return  The COUNTRY stored in the table AGENT
   */
  public String getCountry() {
    return country;
  }

  /**
   * Setter for the agent's country.
   *
   * @param country The agent's country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Getter for the customers assigned to this agent.
   *
   * @return  A set of customers
   */
  public Set<Customer> getCustomers() {
    return customers;
  }

  /**
   * Setter for the customers assigned to this agent.
   *
   * @param customers A set of customers
   */
  public void setCustomers(Set<Customer> customers) {
    this.customers = customers;
  }

  /**
   * Getter for the orders associated with this agent.
   *
   * @return  A set of orders
   */
  public Set<Order> getOrders() {
    return orders;
  }

  /**
   * Setter for the orders associated with this agent.
   *
   * @param orders  A set of orders
   */
  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }
}

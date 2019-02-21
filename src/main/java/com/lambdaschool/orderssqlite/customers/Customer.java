package com.lambdaschool.orderssqlite.customers;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lambdaschool.orderssqlite.agents.Agent;
import com.lambdaschool.orderssqlite.orders.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * CUSTOMER table modeled after the sample database found on W3Resource.
 *
 * @see <a href="https://www.w3resource.com/sql/sql-table.php">W3Resource Sample Database</a>
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CUST_CODE", nullable = false)
  private long custCode;

  @Column(name = "CUST_NAME", nullable = false)
  private String custName;

  @Column(name = "CUST_CITY")
  private String custCity;

  @Column(name = "WORKING_AREA", nullable = false)
  private String workingArea;

  @Column(name = "CUST_COUNTRY", nullable = false)
  private String custCountry;

  @Column(name = "GRADE")
  private String grade;

  @Column(name = "OPENING_AMT", nullable = false)
  private double openingAmt;

  @Column(name = "RECEIVE_AMT", nullable = false)
  private double receiveAmt;

  @Column(name = "PAYMENT_AMT", nullable = false)
  private double paymentAmt;

  @Column(name = "OUTSTANDING_AMT", nullable = false)
  private double outstandingAmt;

  @Column(name = "PHONE_NO", nullable = false)
  private String phone;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "AGENT_CODE", nullable = false)
  private Agent agent;

  @JsonManagedReference
  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
  private Set<Order> orders = new HashSet<>();

  /**
   * Default Constructor
   */
  public Customer() { }

  /**
   * Getter for the customer code.
   *
   * @return The CUST_CODE stored in table CUSTOMER
   */
  public long getCustCode() {
    return custCode;
  }

  /**
   * Getter for the customer name.
   *
   * @return The CUST_NAME stored in table CUSTOMER
   */
  public String getCustName() {
    return custName;
  }

  /**
   * Setter for the customer name.
   *
   * @param custName  The name of the customer
   */
  public void setCustName(String custName) {
    this.custName = custName;
  }

  /**
   * Getter for the customer's city.
   *
   * @return The CUST_CITY stored in table CUSTOMER
   */
  public String getCustCity() {
    return custCity;
  }

  /**
   * Setter for the customer's city.
   *
   * @param custCity  The customer's city
   */
  public void setCustCity(String custCity) {
    this.custCity = custCity;
  }

  /**
   * Getter for the customer's working area.
   *
   * @return The WORKING_AREA stored in table CUSTOMER
   */
  public String getWorkingArea() {
    return workingArea;
  }

  /**
   * Setter for the customer's working area.
   *
   * @param workingArea The customer's working area
   */
  public void setWorkingArea(String workingArea) {
    this.workingArea = workingArea;
  }

  /**
   * Getter for the customer's country.
   *
   * @return The CUST_COUNTRY stored in table CUSTOMER
   */
  public String getCustCountry() {
    return custCountry;
  }

  /**
   * Setter for the customer's country.
   *
   * @param custCountry The customer's country
   */
  public void setCustCountry(String custCountry) {
    this.custCountry = custCountry;
  }

  /**
   * Getter for the customer's grade.
   *
   * @return The GRADE stored in table CUSTOMER
   */
  public String getGrade() {
    return grade;
  }

  /**
   * Setter for the customer's grade.
   *
   * @param grade The customer's grade
   */
  public void setGrade(String grade) {
    this.grade = grade;
  }

  /**
   * Getter for the customer's opening amount.
   *
   * @return The OPENING_AMT stored in table CUSTOMER
   */
  public double getOpeningAmt() {
    return openingAmt;
  }

  /**
   * Setter for the customer's opening amount.
   *
   * @param openingAmt  The customer's opening amount
   */
  public void setOpeningAmt(double openingAmt) {
    this.openingAmt = openingAmt;
  }

  /**
   * Getter for the customer's receiving amount.
   *
   * @return The RECEIVE_AMT stored in table CUSTOMER
   */
  public double getReceiveAmt() {
    return receiveAmt;
  }

  /**
   * Setter for the customer's receiving amount.
   *
   * @param receiveAmt  The customer's receiving amount
   */
  public void setReceiveAmt(double receiveAmt) {
    this.receiveAmt = receiveAmt;
  }

  /**
   * Getter for the customer's payment amount.
   *
   * @return The PAYMENT_AMT stored in table CUSTOMER
   */
  public double getPaymentAmt() {
    return paymentAmt;
  }

  /**
   * Setter for the customer's payment amount.
   *
   * @param paymentAmt  The customer's payment amount
   */
  public void setPaymentAmt(double paymentAmt) {
    this.paymentAmt = paymentAmt;
  }

  /**
   * Getter for the customer's outstanding amount.
   *
   * @return The OUTSTANDING_AMT stored in table CUSTOMER
   */
  public double getOutstandingAmt() {
    return outstandingAmt;
  }

  /**
   * Setter for the customer's outstanding amount.
   *
   * @param outstandingAmt  The customer's outstanding amount
   */
  public void setOutstandingAmt(double outstandingAmt) {
    this.outstandingAmt = outstandingAmt;
  }

  /**
   * Getter for the customer's phone number.
   *
   * @return The PHONE_NO stored in table CUSTOMER
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Setter for the customer's phone number.
   *
   * @param phone The customer's phone number
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Getter for the agent assigned to this customer.
   *
   * @return An Agent
   */
  public Agent getAgent() {
    return agent;
  }

  /**
   * Setter for the agent assigned to this customer.
   *
   * @param agent An Agent
   */
  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  /**
   * Getter for the orders belonging to this customer.
   *
   * @return A set of orders for this customer
   */
  public Set<Order> getOrders() {
    return orders;
  }

  /**
   * Setter for the orders belonging to this customer.
   *
   * @param orders  A set of orders for this customer
   */
  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }
}

package com.lambdaschool.orderssqlite.customers;

import com.lambdaschool.orderssqlite.customers.projections.CustomerSummary;
import com.lambdaschool.orderssqlite.customers.projections.OrderListByCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Customer REST Controller
 */
@RestController
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
  @Autowired
  private CustomerRepository customerRepo;

  /**
   * Find all customers.
   *
   * @return  A list of all customers
   */
  @GetMapping()
  public List<CustomerSummary> findAllCustomers() {
    return customerRepo.findAllBy();
  }

  /**
   * Find customer by the customer code.
   *
   * @param customerCode  The customer code
   * @return              A customer summary or null if customer is not found
   */
  @GetMapping("/custcode/{customerCode}")
  public CustomerSummary findCustomerByCustomerCode(@PathVariable Long customerCode) {
    return customerRepo.findByCustomerCode(customerCode);
  }

  /**
   * Find all orders by the customer name.
   *
   * @param customerName  The customer name
   * @return              A list of each matching customer and their orders
   */
  @GetMapping("/name/{customerName}")
  public List<OrderListByCustomer> findOrdersByCustomerName(@PathVariable String customerName) {
    return customerRepo.findOrderListByCustomerName(customerName);
  }

  /**
   * Find all customers with their orders.
   *
   * @return  A list of all customers with their orders
   */
  @GetMapping("/orders")
  public List<OrderListByCustomer> findAllCustomerOrders() {
    return customerRepo.findAllCustomerOrderListsBy();
  }

  @GetMapping("/orders/{customerCode}")
  public OrderListByCustomer findOrdersByCustomerCode(@PathVariable long customerCode) {
    return customerRepo.findOrderListByCustomerCode(customerCode);
  }

  /**
   * Find all orders for customers with the given name.
   *
   * @param customerName  A customer name
   * @return              A list of customers with the given name and their orders
   */
//  @GetMapping("/name/{customerName}")
//  public List<OrderListByCustomer> findOrdersByCustomerName(@PathVariable String customerName) {
//    return customerRepo.findByCustomerName(customerName);
//  }

  /**
   * Find all orders for the given customer code.
   *
   * @param customerCode  A customer code
   * @return              A list of all orders associated with the given customer code
   */
//  @GetMapping("/order/{customerCode}")
//  public OrderList findOrdersByCustomerCode(@PathVariable long customerCode) {
//    return customerRepo.findByCustomerCode(customerCode);
//  }

  /**
   * Delete customer associated with given customer code.
   *
   * @param customerCode  A customer code
   */
//  @DeleteMapping("/{customerCode}")
//  public void deleteCustomer(@PathVariable long customerCode) {
//    customerRepo.deleteById(customerCode);
//  }
}

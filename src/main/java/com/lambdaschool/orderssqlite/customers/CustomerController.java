package com.lambdaschool.orderssqlite.customers;

import com.lambdaschool.orderssqlite.customers.projections.CustomerSummary;
import com.lambdaschool.orderssqlite.customers.projections.OrderListByCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
   * @return              A list of each matching customer and their order lists
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

  /**
   * Find all orders for a customer based on the customer code.
   *
   * @param customerCode  The customer code
   * @return              The matching customer and their order list
   */
  @GetMapping("/orders/{customerCode}")
  public OrderListByCustomer findOrdersByCustomerCode(@PathVariable long customerCode) {
    return customerRepo.findOrderListByCustomerCode(customerCode);
  }

  /**
   * Create a new customer.
   *
   * @param customer  A customer JSON data object
   * @return          The saved customer
   */
  @PostMapping()
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerRepo.save(customer);
  }

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

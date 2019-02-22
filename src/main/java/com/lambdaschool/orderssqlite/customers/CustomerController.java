package com.lambdaschool.orderssqlite.customers;

import com.lambdaschool.orderssqlite.customers.projections.CustomerSummary;
import com.lambdaschool.orderssqlite.customers.projections.OrderList;
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
   * Find all customers with their orders.
   *
   * @return  A list of all customers with their orders
   */
//  @GetMapping("/order")
//  public List<OrderListByCustomer> findAllCustomers() {
//    return customerRepo.findAllCustomerOrderListBy();
//  }

  /**
   * Find all orders for customers with the given name.
   *
   * @param customerName  A customer name
   * @return              A list of customers with the given name and their orders
   */
  @GetMapping("/name/{customerName}")
  public List<OrderListByCustomer> findOrdersByCustomerName(@PathVariable String customerName) {
    return customerRepo.findByCustomerName(customerName);
  }

  /**
   * Find all orders for the given customer code.
   *
   * @param customerCode  A customer code
   * @return              A list of all orders associated with the given customer code
   */
  @GetMapping("/order/{customerCode}")
  public OrderList findOrdersByCustomerCode(@PathVariable long customerCode) {
    return customerRepo.findByCustomerCode(customerCode);
  }

  /**
   * Delete customer associated with given customer code.
   *
   * @param customerCode  A customer code
   */
  @DeleteMapping("/{customerCode}")
  public void deleteCustomer(@PathVariable long customerCode) {
    customerRepo.deleteById(customerCode);
  }
}

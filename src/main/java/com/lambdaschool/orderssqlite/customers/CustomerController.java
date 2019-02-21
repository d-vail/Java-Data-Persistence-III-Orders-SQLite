package com.lambdaschool.orderssqlite.customers;

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
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
  @Autowired
  private CustomerRepository customerRepo;

  /**
   * Find all customers with their orders.
   *
   * @return  A list of all customers with their orders
   */
  @GetMapping("/order")
  public List<OrderListByCustomer> findAllCustomers() {
    return customerRepo.findAllProjectedBy();
  }

  /**
   * Find all orders for customers with the given name.
   *
   * @param custName  A customer name
   * @return          A list of customers with the given name and their orders
   */
  @GetMapping("/name/{custName}")
  public List<OrderListByCustomer> findOrdersByCustomerName(@PathVariable String custName) {
    return customerRepo.findByCustName(custName);
  }

  /**
   * Find all orders for the given customer code.
   *
   * @param custCode  A customer code
   * @return          A list of all orders associated with the given customer code
   */
  @GetMapping("/order/{custCode}")
  public OrderList findOrdersByCustomerCode(@PathVariable long custCode) {
    return customerRepo.findByCustCode(custCode);
  }

  /**
   * Delete customer associated with given customer code.
   *
   * @param custcode  A customer code
   */
  @DeleteMapping("/{custcode}")
  public void deleteCustomer(@PathVariable long custcode) {
    customerRepo.deleteById(custcode);
  }
}

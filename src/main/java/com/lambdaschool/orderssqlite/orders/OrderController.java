package com.lambdaschool.orderssqlite.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Order REST Controller
 */
@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
  @Autowired
  private OrderRepository orderRepo;

  /**
   * Find all orders
   *
   * @return  A list of all orders
   */
  @GetMapping()
  public List<Order> findAllOrders() {
    return orderRepo.findAll();
  }
}

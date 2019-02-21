package com.lambdaschool.orderssqlite.customers;

import com.lambdaschool.orderssqlite.customers.projections.OrderList;
import com.lambdaschool.orderssqlite.customers.projections.OrderListByCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * A database interface for the customer table
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<OrderListByCustomer> findAllCustomerOrderListBy();
  List<OrderListByCustomer> findByCustomerName(String customerName);
  OrderList findByCustomerCode(long customerCode);
}

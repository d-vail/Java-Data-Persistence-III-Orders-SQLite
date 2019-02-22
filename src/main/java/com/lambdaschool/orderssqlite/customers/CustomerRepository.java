package com.lambdaschool.orderssqlite.customers;

import com.lambdaschool.orderssqlite.customers.projections.CustomerSummary;
import com.lambdaschool.orderssqlite.customers.projections.OrderListByCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * A database interface for the customer table
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  CustomerSummary findByCustomerCode(long customerCode);
  OrderListByCustomer findOrderListByCustomerCode(long customerCode);
  List<CustomerSummary> findAllBy();
  List<OrderListByCustomer> findOrderListByCustomerName(String customerName);
  List<OrderListByCustomer> findAllCustomerOrderListsBy();
}

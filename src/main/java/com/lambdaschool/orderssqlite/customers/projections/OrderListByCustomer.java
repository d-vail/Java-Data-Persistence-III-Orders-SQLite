package com.lambdaschool.orderssqlite.customers.projections;

import com.lambdaschool.orderssqlite.orders.Order;

import java.util.Set;

/**
 * An interface-based projection to restrict query results to a customer's code, name, and
 * associated orders.
 */
public interface OrderListByCustomer {
  Long getCustCode();
  String getCustName();
  Set<Order> getOrders();
}

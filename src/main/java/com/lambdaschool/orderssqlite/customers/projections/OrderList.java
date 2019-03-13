package com.lambdaschool.orderssqlite.customers.projections;

import com.lambdaschool.orderssqlite.orders.Order;

import java.util.Set;

/**
 * An interface-based projection to restrict query results to a list of orders only.
 */
public interface OrderList {
  Set<Order> getOrders();
}

package com.lambdaschool.orderssqlite.customers.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lambdaschool.orderssqlite.orders.Order;

import java.util.Set;

/**
 * An interface-based projection to restrict query results to a customer's code, name, and
 * associated orders.
 */
@JsonPropertyOrder({"customerCode", "customerName", "orders"})
public interface OrderListByCustomer {
  Long getCustomerCode();
  String getCustomerName();
  Set<Order> getOrders();
}

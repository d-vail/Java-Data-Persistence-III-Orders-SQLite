package com.lambdaschool.orderssqlite.agents.projections;

import java.util.Set;

/**
 * A nested interface-based projection to restrict query results to an agent's code, name and
 * associated orders. Orders are restricted to order number and description.
 */
public interface AgentOrderList {
  Long getAgentCode();
  String getAgentName();
  Set<OrderList> getOrders();

  interface OrderList {
    long getOrderNum();
    String getOrdDescription();
  }
}

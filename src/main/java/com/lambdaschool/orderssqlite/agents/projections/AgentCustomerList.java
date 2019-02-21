package com.lambdaschool.orderssqlite.agents.projections;

import java.util.Set;

/**
 * A nested interface-based projection to restrict query results to an agent's code, name, working
 * area, commission, phone number and customer list. Customers are restricted to the customer code,
 * name and phone number.
 */
public interface AgentCustomerList {
  Long getAgentCode();
  String getAgentName();
  String getWorkingArea();
  double getCommission();
  String getPhone();
  Set<CustomerList> getCustomers();

  interface CustomerList {
    long getCustCode();
    String getCustName();
    String getPhone();
  }
}

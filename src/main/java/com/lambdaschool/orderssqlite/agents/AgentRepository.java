package com.lambdaschool.orderssqlite.agents;

import com.lambdaschool.orderssqlite.agents.projections.AgentCustomerList;
import com.lambdaschool.orderssqlite.agents.projections.AgentOrderList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * A database interface for the agents table
 */
public interface AgentRepository extends JpaRepository<Agent, Long> {
  Agent findByAgentCode(long agentCode);
  List<AgentCustomerList> findAllAgentCustomerListBy();
  List<AgentOrderList> findAllAgentOrderListBy();
}

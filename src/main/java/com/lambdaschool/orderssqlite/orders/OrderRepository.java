package com.lambdaschool.orderssqlite.orders;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A database interface for the orders table
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}

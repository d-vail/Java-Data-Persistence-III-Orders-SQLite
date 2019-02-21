# Java Backend Data Persistence with SQL, Hibernate - RESTful SQLite

## Orders SQLite Project

### Introduction

This is a basic database scheme with customers, orders, and sales agents.

### Instructions

Create a REST api server to store and read data from the provided SQLite Database called `orders.db` The database is 
adapted from the sample database found at [https://www.w3resource.com/sql/sql-table.php](https://www.w3resource.com/sql/sql-table.php).
This a continuation of the [java-orders project](https://github.com/d-vail/Java-Data-Persistence-II-Orders).

#### Convert to using SQLite

The table layouts are as follows

- AGENTS
  - AGENTCODE primary key, not null Long
  - AGENTNAME string
  - WORKINGAREA string
  - COMMISSION double
  - PHONE string
  - COUNTRY string
- CUSTOMER
  - CUSTCODE primary key, not null Long
  - CUSTNAME String, not null
  - CUSTCITY String
  - WORKINGAREA String
  - CUSTCOUNTRY String
  - GRADE String
  - OPENINGAMT double
  - RECEIVEAMT double
  - PAYMENTAMT double
  - OUTSTANDINGAMT double
  - PHONE String
  - AGENTCODE Long foreign key (one agent to many customers) not null
- ORDERS
  - ORDNUM primary key, not null Long
  - ORDAMOUNT double
  - ADVANCEAMOUNT double
  - CUSTCODE Long foreign key (one customer to many orders) not null
  - AGENTCODE Long foreign key (one agent to many orders) not null
  - ORDDESCRIPTION

#### Add additional endpoints

All endpoints should return null when no data is found. `DELETE` endpoints should return the data that is deleted and 
`PUT` endpoints should return a copy of the data that was updated.

| Method    | Endpoint                          | Action |                                                            
| --------- | --------------------------------- | ------ |
| GET       | /customers                        | Returns all the customers |
| GET       | /customers/custcode/{custcode}    | Returns a customer based on the customer code |
| GET       | /customers/name/{custname}        | Returns all orders for a customer based on name |
| GET       | /customers/orders                 | Returns all customers with their orders   |
| GET       | /customers/orders/{custcode}      | Returns all orders for a customer based the customer code    |
| GET       | /orders                           | Returns all the orders    |
| GET       | /orders/ordnum/{ordnum}           | Returns an order based on the order number    |
| GET       | /agents                           | Returns all the agents    |
| GET       | /agents/agentcode/{agentcode}     | Returns an agent based on the agent code  |
| GET       | /agents/customers                 | Returns all agents with their customers   |
| GET       | /agents/orders                    | Returns all agents names with their associated order numbers and order descriptions  |
| POST      | /customers                        | Creates a customer    |
| POST      | /orders                           | Creates an order  |
| POST      | /agents                           | Creates an agent  |
| PUT       | /customers/custcode/{custcode}    | Updates a customer based on the customer code |
| PUT       | /orders/ordnum/{ordnum}           | Updates an order based on the order number    |
| PUT       | /agents/agentcode/{agentcode}     | Updates an agent based on the agent code  |
| DELETE    | /customers/custcode/{custcode}    | Deletes a customer based on the customer code and deletes all their associated orders |
| DELETE    | /orders/ordnum/{ordnum}           | Deletes an order based on the order number    |
| DELETE    | /agents/agentcode/{agentcode}     | Deletes an agent based on the agent code if they are not assigned to a customer or order  |

#### Expose actuator endpoints

Expose at least the following the actuator endpoints to help with system management:

- /health
- /inf
- /metrics

### Stretch Goals

Update each of these three actuator endpoints to report your own messages:

- /health
- /inf
- /metrics
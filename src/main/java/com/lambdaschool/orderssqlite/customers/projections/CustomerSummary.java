package com.lambdaschool.orderssqlite.customers.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An interface-based projection to display a summary of the customer data.
 */
@JsonPropertyOrder({"customerCode", "customerName", "customerCity", "customerCountry",
        "workingArea", "phone", "grade", "openingAmount", "receiveAmount", "paymentAmount",
        "outstandingAmount"})
public interface CustomerSummary {
  long getCustomerCode();
  String getCustomerName();
  String getCustomerCity();
  String getCustomerCountry();
  String getWorkingArea();
  String getPhone();
  String getGrade();
  double getOpeningAmount();
  double getReceiveAmount();
  double getPaymentAmount();
  double getOutstandingAmount();
}

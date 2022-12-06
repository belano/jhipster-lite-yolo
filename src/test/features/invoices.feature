Feature: Invoices

  Scenario: Create and get invoice
    Given I create an invoice
      | Quantity | Unit price |
      | 1        | 450.00     |
      | 2        | 500.00     |
    When I get the invoice
    Then I should have the invoice
      | Total. Amount | 1450.00 |

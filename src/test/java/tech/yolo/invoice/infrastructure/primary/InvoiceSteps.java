package tech.yolo.invoice.infrastructure.primary;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tech.yolo.cucumber.CucumberAssertions;
import tech.yolo.cucumber.CucumberRestTemplate;
import tech.yolo.cucumber.CucumberTestContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceSteps {

  @Autowired
  private CucumberRestTemplate rest;

  @Given("I create an invoice")
  public void iCreateAnInvoice(List<Map<String, String>> lines) {
    String payload = "{\"lines\": [" + linesPayload(lines) + "]}";
    rest.post("/api/invoices", payload);
  }

  private String linesPayload(List<Map<String, String>> lines) {
    return lines.stream()
      .map(line -> "{\n" +
        "\"quantity\": " + line.get("Quantity") + ",\n" +
        "  \n" +
        " \"unitPrice\": {\n" +
        "    \"amount\": " + line.get("Unit price") + ",\n" +
        "    \"currency\": \"EURO\"}}")
      .collect(Collectors.joining(","));
  }

  @When("I get the invoice")
  public void iGetTheInvoice() {
    rest.get("/api/invoices/" + CucumberTestContext.getElement("$.id"));
  }

  @Then("I should have the invoice")
  public void iShouldHaveTheInvoice(Map<String, String> invoice) {
    CucumberAssertions.assertThatLastResponse()
      .hasOkStatus()
      .hasResponse()
      .containing(invoice);
  }
}

package tech.yolo.invoice.infrastructure.primary;

import org.junit.jupiter.api.Test;
import tech.yolo.JsonHelper;
import tech.yolo.UnitTest;
import tech.yolo.invoice.domain.InvoicesFixture;

import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
class RestInvoiceToCreateTest {

  @Test
  void shouldConvertToDomain() {
    assertThat(JsonHelper.readFromJson(json(), RestInvoiceToCreate.class)
      .toDomain())
      .usingRecursiveComparison()
      .isEqualTo(InvoicesFixture.invoiceToCreate());
  }

  private String json() {
    //language=JSON
    return """
      {
        "lines": [
          {
            "quantity": 2,
            "unitPrice": {
              "amount": 500,
              "currency": "EURO"
            }
          },
          {
            "quantity": 1,
            "unitPrice": {
              "amount": 400,
              "currency": "EURO"
            }
          }
        ]
      }
        """;
  }
}

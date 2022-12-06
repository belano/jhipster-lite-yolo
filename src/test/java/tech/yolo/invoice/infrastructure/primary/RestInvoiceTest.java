package tech.yolo.invoice.infrastructure.primary;

import org.junit.jupiter.api.Test;
import tech.yolo.JsonHelper;
import tech.yolo.UnitTest;
import tech.yolo.invoice.domain.InvoicesFixture;

import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
class RestInvoiceTest {
  @Test
  void shouldSerializeJson() {
    assertThat(JsonHelper.writeAsString(RestInvoice.from(InvoicesFixture.invoice())))
      .isEqualToIgnoringWhitespace(json());
  }

  private String json() {
    return """
      {
        "id": "12ef90b9-d02d-4a44-9e27-748250c274d1",
        "lines": [
          {
            "quantity": 2,
            "unitPrice": {
              "amount": 500.00,
              "currency": "EURO"
            }
          },
          {
            "quantity": 1,
            "unitPrice": {
              "amount": 400.00,
              "currency": "EURO"
            }
          }
        ],
        "total": {
          "amount": 1400.00,
          "currency": "EURO"
        }
      }
            """;
  }
}

package tech.yolo.invoice.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class InvoicesFixture {
  public static Invoice invoice() {
    return new Invoice(invoiceId(), List.of(firstLine(), secondLine()));
  }

  public static InvoiceId invoiceId() {
    return new InvoiceId(UUID.fromString("12ef90b9-d02d-4a44-9e27-748250c274d1"));
  }

  public static Line secondLine() {
    return new Line(new Quantity(1), fee(400));
  }

  public static Line firstLine() {
    return new Line(new Quantity(2), fee(500));
  }

  public static Fee fee(int val) {
    return new Fee(amount(val), Currency.EURO);
  }

  private static Amount amount(int val) {
    return new Amount(new BigDecimal(val));
  }

  public static InvoiceToCreate invoiceToCreate() {
    return new InvoiceToCreate(lines());
  }

  private static Collection<Line> lines() {
    return List.of(firstLine(), secondLine());
  }
}

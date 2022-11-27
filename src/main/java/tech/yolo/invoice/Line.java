package tech.yolo.invoice;

import tech.yolo.error.domain.Assert;

public record Line(Quantity quantity, Fee unitPrice) {
  public Line {
    Assert.notNull("quantity", quantity);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Fee total() {
    return unitPrice().times(quantity());
  }
}

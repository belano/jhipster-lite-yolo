package tech.yolo.invoice;

import tech.yolo.error.domain.Assert;

public record Quantity(int quantity) {
  public Quantity {
    Assert.field("quantity", quantity)
      .min(0);
  }

  public int get() {
    return quantity();
  }
}

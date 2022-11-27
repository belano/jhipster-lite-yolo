package tech.yolo.invoice;

import tech.yolo.error.domain.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Amount(BigDecimal amount) {
  public static final Amount ZERO = new Amount(BigDecimal.ZERO);

  public Amount(BigDecimal amount) {
    Assert.field("amount", amount)
      .notNull()
      .min(0);

    this.amount = amount.setScale(2, RoundingMode.UP);
  }

  public Amount times(Quantity quantity) {
    return new Amount(amount.multiply(new BigDecimal(quantity.get())));
  }

  public Amount add(Amount other) {
    Assert.notNull("other", other);
    return new Amount(amount().add(other.amount));
  }
}
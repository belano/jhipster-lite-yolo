package tech.yolo.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.yolo.invoice.domain.Amount;
import tech.yolo.invoice.domain.Currency;
import tech.yolo.invoice.domain.Fee;

import java.math.BigDecimal;

public record RestFee(BigDecimal amount, Currency currency) {

  public RestFee(@JsonProperty("amount") BigDecimal amount, @JsonProperty("currency") Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public Fee toDomain() {
    return new Fee(new Amount(amount), currency);
  }

  public static RestFee from(Fee fee) {
    return new RestFee(fee.amount()
      .get(), fee.currency());
  }
}

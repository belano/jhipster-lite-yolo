package tech.yolo.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.yolo.invoice.domain.Line;
import tech.yolo.invoice.domain.Quantity;

public record RestLine(int quantity, RestFee unitPrice) {

  public RestLine(@JsonProperty("quantity") int quantity, @JsonProperty("unitPrice") RestFee unitPrice) {
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public Line toDomain() {
    return new Line(new Quantity(quantity), unitPrice.toDomain());
  }

  public static RestLine from(Line line) {
    return new RestLine(line.quantity()
      .quantity(), RestFee.from(line.unitPrice()));
  }
}

package tech.yolo.invoice;

import tech.yolo.error.domain.Assert;

import java.util.UUID;

public record InvoiceId(UUID id) {

  public InvoiceId {
    Assert.notNull("id", id);
  }
}

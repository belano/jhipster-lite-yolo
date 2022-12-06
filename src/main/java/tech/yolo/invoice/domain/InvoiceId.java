package tech.yolo.invoice.domain;

import tech.yolo.error.domain.Assert;

import java.util.UUID;

public record InvoiceId(UUID id) {

  public InvoiceId {
    Assert.notNull("id", id);
  }

  public static InvoiceId newId() {
    return new InvoiceId(UUID.randomUUID());
  }

  public UUID get() {
    return id();
  }
}

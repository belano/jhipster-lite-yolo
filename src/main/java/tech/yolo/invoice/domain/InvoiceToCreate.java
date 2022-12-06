package tech.yolo.invoice.domain;

import tech.yolo.error.domain.Assert;

import java.util.Collection;

public record InvoiceToCreate(Collection<Line> lines) {
  public InvoiceToCreate {
    Assert.notEmpty("lines", lines);
  }

  public Invoice create() {
    return new Invoice(InvoiceId.newId(), lines());
  }

}

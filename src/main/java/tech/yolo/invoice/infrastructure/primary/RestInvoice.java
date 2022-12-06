package tech.yolo.invoice.infrastructure.primary;

import tech.yolo.invoice.domain.Invoice;

import java.util.Collection;
import java.util.UUID;

public record RestInvoice(UUID id, Collection<RestLine> lines, RestFee total) {

  public static RestInvoice from(Invoice invoice) {
    return new RestInvoice(
      invoice.id()
        .get(),
      invoice.lines()
        .stream()
        .map(RestLine::from)
        .toList(),
      RestFee.from(invoice.total()));
  }
}

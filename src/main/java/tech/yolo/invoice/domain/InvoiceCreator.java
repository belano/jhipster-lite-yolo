package tech.yolo.invoice.domain;

import tech.yolo.error.domain.Assert;

public class InvoiceCreator {

  private final InvoicesRepository invoices;

  public InvoiceCreator(InvoicesRepository invoices) {
    this.invoices = invoices;
  }

  public Invoice create(InvoiceToCreate invoiceToCreate) {
    Assert.notNull("invoiceToCreate", invoiceToCreate);

    Invoice invoice = invoiceToCreate.create();
    invoices.save(invoice);

    return invoice;
  }
}

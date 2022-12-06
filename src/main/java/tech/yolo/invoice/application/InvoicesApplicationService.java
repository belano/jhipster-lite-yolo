package tech.yolo.invoice.application;

import org.springframework.stereotype.Service;
import tech.yolo.invoice.domain.*;

import java.util.Optional;

@Service
public class InvoicesApplicationService {

  private final InvoicesRepository invoices;
  private final InvoiceCreator creator;

  public InvoicesApplicationService(InvoicesRepository invoices) {
    this.invoices = invoices;
    creator = new InvoiceCreator(invoices);
  }

  public Invoice create(InvoiceToCreate invoiceToCreate) {
    return creator.create(invoiceToCreate);
  }

  public Optional<Invoice> get(InvoiceId invoice) {
    return invoices.get(invoice);
  }
}

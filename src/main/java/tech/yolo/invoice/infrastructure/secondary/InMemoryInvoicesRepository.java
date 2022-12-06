package tech.yolo.invoice.infrastructure.secondary;

import org.springframework.stereotype.Repository;
import tech.yolo.error.domain.Assert;
import tech.yolo.invoice.domain.Invoice;
import tech.yolo.invoice.domain.InvoiceId;
import tech.yolo.invoice.domain.InvoicesRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryInvoicesRepository implements InvoicesRepository {
  private final Map<InvoiceId, Invoice> invoices = new ConcurrentHashMap<>();

  @Override
  public void save(Invoice invoice) {
    Assert.notNull("invoice", invoice);
    invoices.put(invoice.id(), invoice);
  }

  @Override
  public Optional<Invoice> get(InvoiceId invoice) {
    return Optional.ofNullable(invoices.get(invoice));
  }
}

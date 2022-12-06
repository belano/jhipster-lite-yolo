package tech.yolo.invoice.infrastructure.primary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.yolo.invoice.application.InvoicesApplicationService;
import tech.yolo.invoice.domain.InvoiceId;

import java.util.UUID;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesResource {

  private final InvoicesApplicationService invoices;

  public InvoicesResource(InvoicesApplicationService invoices) {
    this.invoices = invoices;
  }

  @PostMapping
  ResponseEntity<RestInvoice> create(@Validated @RequestBody RestInvoiceToCreate invoice) {
    RestInvoice createdInvoice = RestInvoice.from(invoices.create(invoice.toDomain()));
    return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
  }

  @GetMapping("/{invoice-id}")
  ResponseEntity<RestInvoice> get(@PathVariable("invoice-id") UUID id) {
    return ResponseEntity.of(invoices.get(new InvoiceId(id)).map(RestInvoice::from));
  }

}

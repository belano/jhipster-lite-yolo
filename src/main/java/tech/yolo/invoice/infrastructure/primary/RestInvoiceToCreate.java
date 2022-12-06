package tech.yolo.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.yolo.invoice.domain.InvoiceToCreate;

import java.util.Collection;

public class RestInvoiceToCreate {

  private final Collection<RestLine> lines;

  public RestInvoiceToCreate(@JsonProperty("lines") Collection<RestLine> lines) {
    this.lines = lines;
  }

  public InvoiceToCreate toDomain() {
    return new InvoiceToCreate(getLines()
      .stream()
      .map(RestLine::toDomain)
      .toList()
    );
  }

  private Collection<RestLine> getLines() {
    return lines;
  }
}

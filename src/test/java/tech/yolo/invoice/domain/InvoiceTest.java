package tech.yolo.invoice.domain;

import org.junit.jupiter.api.Test;
import tech.yolo.UnitTest;
import tech.yolo.error.domain.MissingMandatoryValueException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tech.yolo.invoice.domain.InvoicesFixture.*;

@UnitTest
class InvoiceTest {
  @Test
  void shouldNotBuildWithoutLines() {
    assertThatThrownBy(() -> new Invoice(invoiceId(), null)).isExactlyInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("lines");
  }

  @Test
  void shouldNotBuildWithZeroLines() {
    assertThatThrownBy(() -> new Invoice(invoiceId(), List.of())).isExactlyInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("lines");

  }

  @Test
  void shouldGetInvoiceInformation() {
    Invoice invoice = invoice();

    assertThat(invoice.lines()).containsExactly(firstLine(), secondLine());
    assertThat(invoice.total()).isEqualTo(fee(1400));
    assertThat(invoice.id()).hasNoNullFieldsOrProperties();
  }
}

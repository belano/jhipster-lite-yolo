package tech.yolo.invoice.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InvoiceIdTest {
  @Test
  void shouldGenerateIds() {
    assertThat(InvoiceId.newId())
      .isNotNull()
      .isNotEqualTo(InvoiceId.newId());
  }
}

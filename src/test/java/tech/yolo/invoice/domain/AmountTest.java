package tech.yolo.invoice.domain;

import org.junit.jupiter.api.Test;
import tech.yolo.UnitTest;
import tech.yolo.invoice.domain.Amount;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
class AmountTest {
  @Test
  void shouldRoundAtTwoDigits() {
    assertThat(new Amount(new BigDecimal("12.137")))
      .isEqualTo(new Amount(new BigDecimal("12.14")));
  }
}

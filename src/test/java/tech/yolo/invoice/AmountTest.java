package tech.yolo.invoice;

import org.junit.jupiter.api.Test;
import tech.yolo.UnitTest;

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

package ch.noseryoung.vema.domain.coin;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public enum CoinValueEnum {
  TEN_ST(BigDecimal.valueOf(0.1)),
  TWENTY_ST(BigDecimal.valueOf(0.2)),
  FIFTY_ST(BigDecimal.valueOf(0.5)),
  ONE_LEVA(BigDecimal.valueOf(1)),
  TWO_LEVA(BigDecimal.valueOf(2));

  private BigDecimal value;

  CoinValueEnum(BigDecimal value) {
    this.value = value;
  }

  public BigDecimal getValue() {
    return value;
  }

  public static CoinValueEnum get(BigDecimal value) {
    for (CoinValueEnum coinValueEnum : values()) {
      if(coinValueEnum.getValue().equals(value)) {
        return coinValueEnum;
      }
    }
    throw new NoSuchElementException(String.format("Enum value {value} not found", value));
  }
}

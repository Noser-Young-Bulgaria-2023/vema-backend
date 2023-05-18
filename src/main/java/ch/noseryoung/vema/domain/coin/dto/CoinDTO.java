package ch.noseryoung.vema.domain.coin.dto;

import ch.noseryoung.vema.domain.coin.CoinValueEnum;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class CoinDTO {
  @Id
  private String id;

  private BigDecimal coinValue;

  public CoinDTO() {
  }

  public CoinDTO(String id, BigDecimal coinValue) {
    this.id = id;
    this.coinValue = coinValue;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BigDecimal getCoinValue() {
    return coinValue;
  }

  public void setCoinValue(BigDecimal coinValue) {
    this.coinValue = coinValue;
  }
}

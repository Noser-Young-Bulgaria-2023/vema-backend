package ch.noseryoung.vema.domain.coin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Coin {
  @Id
  private String id;

  private CoinValueEnum coinValue;


  public Coin() {
  }

  public Coin(String id, CoinValueEnum coinValue) {
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
    return coinValue.getValue();
  }

  public void setCoinValue(BigDecimal coinValue) {
    this.coinValue = CoinValueEnum.get(coinValue);
  }

}

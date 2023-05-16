package ch.noseryoung.vema.domain.cashregister;

import ch.noseryoung.vema.domain.coin.Coin;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class CashRegister {

  @Id
  private String id;

  private List<Coin> coinsInDeposit;

  private List<Coin> coinsInInternalStorage;

  public CashRegister(String id, List<Coin> coinsInDeposit, List<Coin> coinsInInternalStorage) {
    this.id = id;
    this.coinsInDeposit = coinsInDeposit;
    this.coinsInInternalStorage = coinsInInternalStorage;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Coin> getCoinsInDeposit() {
    return coinsInDeposit;
  }

  public void setCoinsInDeposit(List<Coin> coinsInDeposit) {
    this.coinsInDeposit = coinsInDeposit;
  }

  public List<Coin> getCoinsInInternalStorage() {
    return coinsInInternalStorage;
  }

  public void setCoinsInInternalStorage(List<Coin> coinsInInternalStorage) {
    this.coinsInInternalStorage = coinsInInternalStorage;
  }
}

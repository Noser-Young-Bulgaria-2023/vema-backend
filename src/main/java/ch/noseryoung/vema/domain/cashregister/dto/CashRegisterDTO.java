package ch.noseryoung.vema.domain.cashregister.dto;

import ch.noseryoung.vema.domain.coin.dto.CoinDTO;
import org.springframework.data.annotation.Id;

import java.util.List;

public class CashRegisterDTO {
  @Id
  private String id;

  private List<CoinDTO> coinsInDeposit;

  private List<CoinDTO> coinsInInternalStorage;

  public CashRegisterDTO(String id, List<CoinDTO> coinsInDeposit, List<CoinDTO> coinsInInternalStorage) {
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

  public List<CoinDTO> getCoinsInDeposit() {
    return coinsInDeposit;
  }

  public void setCoinsInDeposit(List<CoinDTO> coinsInDeposit) {
    this.coinsInDeposit = coinsInDeposit;
  }

  public List<CoinDTO> getCoinsInInternalStorage() {
    return coinsInInternalStorage;
  }

  public void setCoinsInInternalStorage(List<CoinDTO> coinsInInternalStorage) {
    this.coinsInInternalStorage = coinsInInternalStorage;
  }
}

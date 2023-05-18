package ch.noseryoung.vema.domain.cashregister;

import ch.noseryoung.vema.domain.coin.Coin;

import java.util.List;

public interface CashRegisterService {
  List<CashRegister> getAll();
  CashRegister getById(String id);
  CashRegister save(CashRegister CashRegister);
  CashRegister updateById(String id, CashRegister CashRegister);
  CashRegister insertCoinById(String id, Coin coin);
  void deleteById(String id);
}

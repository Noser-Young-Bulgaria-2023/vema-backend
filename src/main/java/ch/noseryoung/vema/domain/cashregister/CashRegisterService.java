package ch.noseryoung.vema.domain.cashregister;

import java.util.List;

public interface CashRegisterService {
  List<CashRegister> getAll();
  CashRegister getById(String id);
  CashRegister save(CashRegister CashRegister);
  CashRegister updateById(String id, CashRegister CashRegister);
  void deleteById(String id);
}

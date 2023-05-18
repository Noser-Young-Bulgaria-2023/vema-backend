package ch.noseryoung.vema.domain.cashregister;

import ch.noseryoung.vema.domain.coin.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CashRegisterServiceImpl implements CashRegisterService{
  private CashRegisterRepository repository;

  @Autowired
  public CashRegisterServiceImpl(CashRegisterRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<CashRegister> getAll() {
    return repository.findAll();
  }

  @Override
  public CashRegister getById(String id) {
    return repository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public CashRegister save(CashRegister CashRegister) {
    return repository.save(CashRegister);
  }

  @Override
  public CashRegister updateById(String id, CashRegister CashRegister) {
    if (CashRegister.getId() != null && CashRegister.getId().equals(id)) {
      CashRegister updatedCashRegister = CashRegister;
      updatedCashRegister.setId(id);
      return repository.save(updatedCashRegister);
    }
    throw new RuntimeException("Bad request");
  }

  @Override
  public CashRegister insertCoinById(String id, Coin coin) {
    CashRegister updatedCashRegister = repository.findById(id).orElseThrow(NoSuchElementException::new);
    updatedCashRegister.getCoinsInDeposit().add(coin);
    return repository.save(updatedCashRegister);
  }

  @Override
  public void deleteById(String id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return;
    }
    throw new NoSuchElementException(String.format("No CashRegister with id {id} exists", id));
  }
}

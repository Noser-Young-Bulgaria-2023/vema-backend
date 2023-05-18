package ch.noseryoung.vema.domain.coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CoinServiceImpl implements CoinService {

  CoinRepository repository;

  @Autowired
  public CoinServiceImpl(CoinRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Coin> getAll() {
    return repository.findAll();
  }

  @Override
  public Coin getById(String id) {
    return repository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Coin save(Coin coin) {
    return repository.save(coin);
  }

  @Override
  public Coin updateById(String id, Coin coin) {
    if (coin.getId() != null && coin.getId().equals(id)) {
      Coin updatedCoin = coin;
      updatedCoin.setId(id);
      return repository.save(updatedCoin);
    }
    throw new RuntimeException("Bad request");
  }

  @Override
  public void deleteById(String id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return;
    }
    throw new NoSuchElementException(String.format("No coin with id {id} exists", id));
  }
}

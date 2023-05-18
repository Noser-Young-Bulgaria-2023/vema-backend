package ch.noseryoung.vema.domain.coin;

import java.util.List;

public interface CoinService {
  List<Coin> getAll();
  Coin getById(String id);
  Coin save(Coin coin);
  Coin updateById(String id, Coin coin);
  void deleteById(String id);
}

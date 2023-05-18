package ch.noseryoung.vema.domain.coin;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepository extends MongoRepository<Coin, String> {
}

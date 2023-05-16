package ch.noseryoung.vema.domain.cashregister;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CashRegisterRepository extends MongoRepository<CashRegister, String> {
}

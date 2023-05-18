package ch.noseryoung.vema.domain.cashregister;

import ch.noseryoung.vema.domain.cashregister.dto.CashRegisterDTO;
import ch.noseryoung.vema.domain.cashregister.dto.CashRegisterMapper;
import ch.noseryoung.vema.domain.coin.dto.CoinDTO;
import ch.noseryoung.vema.domain.coin.dto.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cash-register")
public class CashRegisterController {

  private CashRegisterService service;

  private CashRegisterRepository repository;

  private CashRegisterMapper mapper;

  private CoinMapper coinMapper;

  @Autowired
  public CashRegisterController(CashRegisterService service, CashRegisterRepository repository, CashRegisterMapper mapper, CoinMapper coinMapper) {
    this.service = service;
    this.repository = repository;
    this.mapper = mapper;
    this.coinMapper = coinMapper;
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<CashRegisterDTO>> getAll() {
    List<CashRegister> allCashRegisters = service.getAll();
    return new ResponseEntity<>(mapper.toDTOs(allCashRegisters), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CashRegisterDTO> getById(@PathVariable String id) {
    CashRegister CashRegister = service.getById(id);
    return new ResponseEntity<>(mapper.toDTO(CashRegister), HttpStatus.OK);
  }

  @PostMapping({"/", ""})
  public ResponseEntity<CashRegisterDTO> create(@RequestBody CashRegisterDTO CashRegisterDTO) {
    CashRegister newCashRegister = service.save(mapper.fromDTO(CashRegisterDTO));
    return new ResponseEntity<>(mapper.toDTO(newCashRegister), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CashRegisterDTO> updateById(@PathVariable String id, @RequestBody CashRegisterDTO CashRegisterDTO) {
    CashRegister updatedCashRegister = service.updateById(id, mapper.fromDTO(CashRegisterDTO));
    return new ResponseEntity<>(mapper.toDTO(updatedCashRegister), HttpStatus.OK);
  }

  @PutMapping("/{id}/insert-coin")
  public ResponseEntity<CashRegisterDTO> insertCoinById(@PathVariable String id, @RequestBody CoinDTO coinDTO) {
    CashRegister updatedCashRegister = service.insertCoinById(id, coinMapper.fromDTO(coinDTO));
    return new ResponseEntity<>(mapper.toDTO(updatedCashRegister), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable String id) {
    service.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

package ch.noseryoung.vema.domain.cashregister;

import ch.noseryoung.vema.domain.cashregister.dto.CashRegisterDTO;
import ch.noseryoung.vema.domain.cashregister.dto.CashRegisterMapper;
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

  @Autowired
  public CashRegisterController(CashRegisterService service, CashRegisterRepository repository, CashRegisterMapper mapper) {
    this.service = service;
    this.repository = repository;
    this.mapper = mapper;
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<CashRegisterDTO>> getAll() {
    List<CashRegister> allCashRegisters = service.getAll();
    return new ResponseEntity<>(mapper.toDTOs(allCashRegisters), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CashRegisterDTO> getById(@RequestParam String id) {
    CashRegister CashRegister = service.getById(id);
    return new ResponseEntity<>(mapper.toDTO(CashRegister), HttpStatus.OK);
  }

  @PostMapping({"/", ""})
  public ResponseEntity<CashRegisterDTO> create(@RequestBody CashRegisterDTO CashRegisterDTO) {
    CashRegister newCashRegister = service.save(mapper.fromDTO(CashRegisterDTO));
    return new ResponseEntity<>(mapper.toDTO(newCashRegister), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CashRegisterDTO> updateById(@RequestParam String id, @RequestBody CashRegisterDTO CashRegisterDTO) {
    CashRegister updatedCashRegister = service.updateById(id, mapper.fromDTO(CashRegisterDTO));
    return new ResponseEntity<>(mapper.toDTO(updatedCashRegister), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@RequestParam String id) {
    service.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

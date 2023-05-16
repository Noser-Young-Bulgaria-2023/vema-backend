package ch.noseryoung.vema.domain.coin;

import ch.noseryoung.vema.domain.coin.dto.CoinDTO;
import ch.noseryoung.vema.domain.coin.dto.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coins")
public class CoinController {

  private CoinService service;

  private CoinRepository repository;

  private CoinMapper mapper;

  @Autowired
  public CoinController(CoinService service, CoinRepository repository, CoinMapper mapper) {
    this.service = service;
    this.repository = repository;
    this.mapper = mapper;
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<CoinDTO>> getAll() {
    List<Coin> allCoins = service.getAll();
    return new ResponseEntity<>(mapper.toDTOs(allCoins), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CoinDTO> getById(@RequestParam String id) {
    Coin coin = service.getById(id);
    return new ResponseEntity<>(mapper.toDTO(coin), HttpStatus.OK);
  }

  @PostMapping({"/", ""})
  public ResponseEntity<CoinDTO> create(@RequestBody CoinDTO coinDTO) {
    Coin newCoin = service.save(mapper.fromDTO(coinDTO));
    return new ResponseEntity<>(mapper.toDTO(newCoin), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CoinDTO> updateById(@RequestParam String id, @RequestBody CoinDTO coinDTO) {
    Coin updatedCoin = service.updateById(id, mapper.fromDTO(coinDTO));
    return new ResponseEntity<>(mapper.toDTO(updatedCoin), HttpStatus.OK);
  }

   @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@RequestParam String id) {
    service.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
   }
}

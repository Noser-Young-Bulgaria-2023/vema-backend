package ch.noseryoung.vema.domain.coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coins")
public class CoinController {

  private CoinService service;

  private CoinRepository repository;

  @Autowired
  public CoinController(CoinService service, CoinRepository repository) {
    this.service = service;
    this.repository = repository;
  }
}

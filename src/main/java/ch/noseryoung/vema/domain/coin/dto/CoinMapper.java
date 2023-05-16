package ch.noseryoung.vema.domain.coin.dto;

import ch.noseryoung.vema.domain.coin.Coin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CoinMapper {
  CoinDTO toDTO(Coin coin);

  Coin fromDTO(CoinDTO dto);

  List<CoinDTO> toDTOs(List<Coin> coins);

  List<Coin> fromDTOs(List<CoinDTO> dtos);
}

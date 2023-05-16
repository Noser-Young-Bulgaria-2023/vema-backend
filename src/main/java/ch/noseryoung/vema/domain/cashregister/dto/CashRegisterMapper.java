package ch.noseryoung.vema.domain.cashregister.dto;

import ch.noseryoung.vema.domain.cashregister.CashRegister;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CashRegisterMapper {
  CashRegisterDTO toDTO(CashRegister CashRegister);

  CashRegister fromDTO(CashRegisterDTO dto);

  List<CashRegisterDTO> toDTOs(List<CashRegister> CashRegisters);

  List<CashRegister> fromDTOs(List<CashRegisterDTO> dtos);
}

package ch.noseryoung.vema.domain.product.dto;

import java.util.List;

import org.mapstruct.Mapper;

import ch.noseryoung.vema.domain.product.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    Product fromDTO(ProductDTO dto);

    List<ProductDTO> toDTOs(List<Product> products);

    List<Product> fromDTOs(List<ProductDTO> dtos);
}

package ch.noseryoung.vema.domain.product;

import ch.noseryoung.vema.domain.product.dto.ProductDTO;
import ch.noseryoung.vema.domain.product.dto.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;


    @Test
    void testCreate() throws Exception {
        // Arrange
        ProductDTO productDTO = new ProductDTO("1", "Sprite", 2.99f, 10, null);
        Product product = new Product("1", "Sprite", 2.99f, 10, null);

        when(productService.create(any(MultipartFile.class), any(Product.class))).thenReturn(product);
        when(productMapper.fromDTO(any(ProductDTO.class))).thenReturn(product);
        when(productMapper.toDTO(any(Product.class))).thenReturn(productDTO);

        // Act
        ResponseEntity<ProductDTO> responseEntity = productController.create(null, productDTO);

        // Assert
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody().getName()).isEqualTo("Sprite");
    }

    @Test
    void testReadAll() {
        // Arrange
        List<Product> mockedProducts = new ArrayList<>();
        mockedProducts.add(new Product("123", "Coca-Cola", 2.99f, 10, null));

        List<ProductDTO> mockedProductDTOs = new ArrayList<>();
        mockedProductDTOs.add(new ProductDTO("123", "Coca-Cola", 2.99f, 10, null));

        when(productService.readAll()).thenReturn(mockedProducts);
        when(productMapper.toDTOs(any())).thenReturn(mockedProductDTOs);

        // Act
        ResponseEntity<List<ProductDTO>> response = productController.readAll();

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    void testRead() {
        // Arrange
        Product mockedProduct = new Product("1", "Coca-Cola", 2.99f, 10, null);
        ProductDTO mockedProductDTO = new ProductDTO("1", "Coca-Cola", 2.99f, 10, null);

        when(productService.read("1")).thenReturn(mockedProduct);
        when(productMapper.toDTO(any())).thenReturn(mockedProductDTO);

        // Act
        ResponseEntity<ProductDTO> response = productController.read("1");

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo("1");
    }

    @Test
    void testUpdate() throws IOException {
        // Arrange
        Product mockedProduct = new Product("2", "Fanta", 3.99f, 20, null);
        ProductDTO mockedProductDTO = new ProductDTO("2", "Fanta", 3.99f, 20, null);

        when(productService.update(eq("2"), any(), any())).thenReturn(mockedProduct);
        when(productMapper.fromDTO(any())).thenReturn(mockedProduct);
        when(productMapper.toDTO(any())).thenReturn(mockedProductDTO);

        // Act
        ResponseEntity<ProductDTO> response = productController.update("2", null, mockedProductDTO);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo("2");
    }

    @Test
    void testDelete() throws Exception {
        // Act
        ResponseEntity<Void> response = productController.delete(anyString());

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNull();
    }
}

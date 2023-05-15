package ch.noseryoung.vema.domain.product;

import ch.noseryoung.vema.domain.product.exceptions.VendingMachineCapacityExceededException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testCreate() throws VendingMachineCapacityExceededException, IOException {
        // Arrange
        Product product = new Product("1", "Sprite", 2.99f, 10, null);

        when(productRepository.save(any())).thenReturn(product);

        // Act
        Product result = productService.create(null, new Product(null, "Sprite", 2.99f, 10, null));

        // Assert
        assertThat(result).isEqualTo(product);
    }

    @Test
    void testRead() {
        // Arrange
        Product product = new Product("1", "Sprite", 2.99f, 10, null);

        when(productRepository.findById("1")).thenReturn(java.util.Optional.of(product));

        // Act
        Product result = productService.read("1");

        // Assert
        assertThat(result).isEqualTo(product);
    }

    @Test
    void testReadAll() {
        // Arrange
        List<Product> products = new ArrayList<>();

        products.add(new Product("1", "Coca-Cola", 2.99f, 10, null));
        products.add(new Product("2", "Sprite", 3.99f, 5, null));

        when(productRepository.findAll()).thenReturn(products);

        // Act
        List<Product> result = productService.readAll();

        // Assert
        assertThat(result).isEqualTo(products);
    }

    @Test
    void testUpdate() throws IOException {
        // Arrange
        Product product = new Product("1", "Club-Mate", 4.99f, 10, null);

        when(productRepository.save(product)).thenReturn(product);

        // Act
        Product result = productService.update("1", product, null);

        // Assert
        assertThat(result).isEqualTo(product);
    }
}

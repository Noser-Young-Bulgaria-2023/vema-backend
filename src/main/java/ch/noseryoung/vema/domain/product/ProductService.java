package ch.noseryoung.vema.domain.product;

import java.io.IOException;
import java.util.List;

import ch.noseryoung.vema.domain.product.exceptions.ProductNotFoundException;
import ch.noseryoung.vema.domain.product.exceptions.VendingMachineCapacityExceededException;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Product create(MultipartFile productImage, Product product) throws VendingMachineCapacityExceededException, IOException;

    Product read(String id) throws ProductNotFoundException;

    List<Product> readAll();

    Product update(String id, Product product);

    void delete(String id);
}

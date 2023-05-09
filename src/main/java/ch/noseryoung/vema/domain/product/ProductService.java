package ch.noseryoung.vema.domain.product;

import java.util.List;

import ch.noseryoung.vema.domain.product.exceptions.ProductNotFoundException;
import ch.noseryoung.vema.domain.product.exceptions.VendingMachineCapacityExceededException;

public interface ProductService {
    Product create(Product product) throws VendingMachineCapacityExceededException;

    Product read(String id) throws ProductNotFoundException;

    List<Product> readAll();

    Product update(String id, Product product);

    void delete(String id);
}

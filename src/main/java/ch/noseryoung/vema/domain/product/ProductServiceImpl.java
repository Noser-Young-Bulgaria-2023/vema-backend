package ch.noseryoung.vema.domain.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.vema.domain.product.exceptions.ProductNotFoundException;
import ch.noseryoung.vema.domain.product.exceptions.VendingMachineCapacityExceededException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository repository;

    public ProductServiceImpl(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) throws VendingMachineCapacityExceededException {
        List<Product> products = readAll();

        if (products.size() >= 10) {
            throw new VendingMachineCapacityExceededException();
        }

        return repository.save(product);
    }

    @Override
    public Product read(String id) throws ProductNotFoundException {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<Product> readAll() {
        return repository.findAll();
    }

    @Override
    public Product update(String id, Product product) {
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

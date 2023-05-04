package ch.noseryoung.vema.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository repository;

    public ProductServiceImpl(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        System.out.println("Adding new product");
        return new Product("1", "Some product");
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}

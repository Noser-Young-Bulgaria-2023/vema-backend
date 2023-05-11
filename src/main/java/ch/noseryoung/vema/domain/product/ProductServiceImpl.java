package ch.noseryoung.vema.domain.product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinary;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.vema.domain.product.exceptions.ProductNotFoundException;
import ch.noseryoung.vema.domain.product.exceptions.VendingMachineCapacityExceededException;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository repository;

    public ProductServiceImpl(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(MultipartFile productImage, Product product) throws VendingMachineCapacityExceededException, IOException {
        List<Product> products = readAll();

        if (products.size() >= 10) {
            throw new VendingMachineCapacityExceededException();
        }

        product.setImage(new Binary(BsonBinarySubType.BINARY, productImage.getBytes()));

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

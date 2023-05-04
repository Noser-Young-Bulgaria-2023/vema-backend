package ch.noseryoung.vema.domain.product;

public interface ProductService {
    Product saveProduct(Product product);

    void deleteAll();
}

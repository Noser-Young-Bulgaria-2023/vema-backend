package ch.noseryoung.vema.domain.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.noseryoung.vema.domain.product.exceptions.ProductNotFoundException;
import ch.noseryoung.vema.domain.product.exceptions.VendingMachineCapacityExceededException;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        super();
        this.service = service;
    }

    @PostMapping({ "/", "" })
    public ResponseEntity<Product> create(@RequestBody Product product) throws VendingMachineCapacityExceededException {
        Product savedProduct = service.create(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Product>> readAll() {
        List<Product> products = service.readAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping({ "/{productId}/", "/{productId}" })
    public ResponseEntity<Product> read(@PathVariable String productId) {
        Product product = service.read(productId);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping({ "/{productId}/", "/{productId}" })
    public ResponseEntity<Product> update(@PathVariable String productId, @RequestBody Product product) {
        Product updatedProduct = service.update(productId, product);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping({ "/{productId}/", "/{productId}" })
    public ResponseEntity<Void> delete(@PathVariable String productId) {
        service.delete(productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Vending machine at full capacity")
    @ExceptionHandler(VendingMachineCapacityExceededException.class)
    public void handleMachineCapacityExceeded() {
        // Nothing to do
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product is not present in the vending machine")
    @ExceptionHandler(ProductNotFoundException.class)
    public void handleProductNotFound() {
        // Nothing to do
    }
}

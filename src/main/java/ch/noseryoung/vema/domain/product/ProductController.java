package ch.noseryoung.vema.domain.product;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.noseryoung.vema.domain.product.dto.ProductDTO;
import ch.noseryoung.vema.domain.product.dto.ProductMapper;
import ch.noseryoung.vema.domain.product.exceptions.ProductNotFoundException;
import ch.noseryoung.vema.domain.product.exceptions.VendingMachineCapacityExceededException;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    public ProductController(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping({ "/", "" })
    public ResponseEntity<ProductDTO> create(@RequestPart("product-image") MultipartFile productImage,
                                             @RequestPart("product") ProductDTO productDTO)
            throws VendingMachineCapacityExceededException, IOException {
        Product savedProduct = service.create(productImage, mapper.fromDTO(productDTO));

        return new ResponseEntity<>(mapper.toDTO(savedProduct), HttpStatus.CREATED);
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<ProductDTO>> readAll() {
        List<Product> products = service.readAll();

        return new ResponseEntity<>(mapper.toDTOs(products), HttpStatus.OK);
    }

    @GetMapping({ "/{productId}/", "/{productId}" })
    public ResponseEntity<ProductDTO> read(@PathVariable String productId) {
        Product product = service.read(productId);
        return new ResponseEntity<>(mapper.toDTO(product), HttpStatus.OK);
    }

    @PutMapping({ "/{productId}/", "/{productId}" })
    public ResponseEntity<ProductDTO> update(@PathVariable String productId, @RequestPart("product-image") MultipartFile productImage,
                                             @RequestPart("product") ProductDTO productDTO) throws IOException {
        Product updatedProduct = service.update(productId, mapper.fromDTO(productDTO), productImage);

        return new ResponseEntity<>(mapper.toDTO(updatedProduct), HttpStatus.OK);
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

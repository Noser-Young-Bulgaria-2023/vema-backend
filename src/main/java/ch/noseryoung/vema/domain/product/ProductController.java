package ch.noseryoung.vema.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<String> getProduct() {
        service.deleteAll();
        return new ResponseEntity<String>("Hello Product", HttpStatus.OK);
    }
}

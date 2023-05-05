package ch.noseryoung.vema.domain.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such product has been found in the vending machine")
public class ProductNotFoundException extends RuntimeException {
}

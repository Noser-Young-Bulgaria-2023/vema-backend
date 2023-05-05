package ch.noseryoung.vema.domain.product.exceptions;

public class VendingMachineCapacityExceededException extends Exception {

    public VendingMachineCapacityExceededException() {
        super("Vending machine is at full capacity. Not more than 10 products are allowed.");
    }

}

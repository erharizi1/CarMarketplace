package de.mobile.exception;

public class CustomerNotFoundException extends  RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Customer is not found -- id : " + id);
    }
}

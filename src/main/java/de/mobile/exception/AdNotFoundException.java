package de.mobile.exception;

public class AdNotFoundException extends  RuntimeException {

    public  AdNotFoundException(Long id) {
        super("Advertisement is not found -- id : " + id);
    }
}

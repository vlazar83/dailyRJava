package com.vlazar83.dailyRJava;

public class ReadingNotFoundException extends RuntimeException {

    public ReadingNotFoundException(Long id) {
        super("Could not find reading " + id);
    }

}

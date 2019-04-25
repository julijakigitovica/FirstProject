package com.javaguru.shoppinglist;

public class NameValidation {
    public void validateName(Product product) throws ValidationException{
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ValidationException("Name can not be less than 3 characters and more than 32");
        }
    }
}

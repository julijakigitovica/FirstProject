package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class NameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkProductNotNull(product);
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ValidationException("Name can not be less than 3 characters and more than 32");
        }
    }
}

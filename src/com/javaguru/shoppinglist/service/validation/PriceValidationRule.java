package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class PriceValidationRule implements ProductValidationRule {

    public static final BigDecimal MIN_PRICE = new BigDecimal(0);

    @Override
    public void validate(Product product) {
        checkProductNotNull(product);
        if (product.getPrice().compareTo(MIN_PRICE) <= 0) {
            throw new ValidationException("Product price must be greater than 0");
        }
    }
}

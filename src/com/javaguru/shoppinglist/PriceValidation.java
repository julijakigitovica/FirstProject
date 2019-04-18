package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class PriceValidation {
    public static final BigDecimal MIN_PRICE = new BigDecimal(0);

    public void validatePrice(Product product) throws ValidationException {
        if (product.getPrice().compareTo(MIN_PRICE) <= 0) {
            throw new ValidationException("Product price must be greater than 0");
        }
    }
}

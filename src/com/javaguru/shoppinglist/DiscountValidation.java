package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class DiscountValidation {
    public static final BigDecimal MAX_DISCOUNT = new BigDecimal(100);

    public void validateDiscount(Product product) throws ValidationException {
        if (product.getDiscount().compareTo(MAX_DISCOUNT) >= 0)
            throw new ValidationException("Discount should not be greater than 100%");
    }

}

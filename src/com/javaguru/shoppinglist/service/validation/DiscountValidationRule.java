package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class DiscountValidationRule implements ProductValidationRule {

    public static final BigDecimal MAX_DISCOUNT = new BigDecimal(100);

    @Override
    public void validate(Product product) {
        checkProductNotNull(product);
        if (product.getDiscount().compareTo(MAX_DISCOUNT) >= 0)
            throw new ValidationException("Discount should not be greater than 100%");
    }

}

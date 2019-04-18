package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;
    private NameValidation nameValidation;
    private DiscountValidation discountValidation;
    private PriceValidation priceValidation;


    public CreateProductAction(ProductService productService,NameValidation nameValidation,
                               DiscountValidation discountValidation,PriceValidation priceValidation) {
        this.productService = productService;
        this.nameValidation = nameValidation;
        this.discountValidation = discountValidation;
        this.priceValidation = priceValidation;


    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        System.out.println("Enter product discount: ");
        String discount = scanner.nextLine();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();


        Product product = new Product();
        product.setDescription(description);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(new BigDecimal(discount));

        System.out.println("Actual price:" + product.calculateActualPrice());

        try {
            nameValidation.validateName(product);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        try {
            priceValidation.validatePrice(product);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        try {
            discountValidation.validateDiscount(product);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }


        try {
            Long response = productService.create(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}

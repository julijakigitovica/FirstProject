package com.javaguru.shoppinglist;

import java.util.ArrayList;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {
        ProductService productService = new DefaultProductService();

        NameValidation nameValidation =new NameValidation();
        DiscountValidation discountValidation=new DiscountValidation();
        PriceValidation priceValidation=new PriceValidation();


        Action exitAction = new ExitAction();
        Action createUserAction = new CreateProductAction(productService,nameValidation,discountValidation,
                priceValidation);
        Action findUserByIdAction = new FindProductByIdAction(productService);

        List<Action> actions = new ArrayList<>();
        actions.add(findUserByIdAction);
        actions.add(createUserAction);
        actions.add(exitAction);

        ConsoleUI ui = new ConsoleUI(actions);
        ui.start();
    }
}

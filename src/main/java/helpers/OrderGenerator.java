package helpers;

import models.CreateOrder;

import java.util.List;
import java.util.Random;

import static helpers.DataGenerator.randomString;

public class OrderGenerator {

    final static String DEFAULT_INGREDIENT_HASH = "61c0c5a71d1f82001bdaaa6d";
    final static String INCORRECT_INGREDIENT_HASH = randomString(4);

    public static CreateOrder getDefaultOrder() {
        return new CreateOrder(List.of(DEFAULT_INGREDIENT_HASH));
    }

    public static CreateOrder getOrderWithoutIngredients() {
        return new CreateOrder(List.of());
    }

    public static CreateOrder getOrderWithIncorrectHash() {
        return new CreateOrder(List.of(INCORRECT_INGREDIENT_HASH));
    }
}

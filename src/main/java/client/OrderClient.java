package client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.CreateOrder;

import static io.restassured.RestAssured.given;

public class OrderClient extends  Client{

    private final static String ORDERS_PATH = "api/orders";

    @Step("Создание заказа")
    public static ValidatableResponse createOrder(CreateOrder data, String bearerPlusToken) {
        return given()
                .spec(getSpec(bearerPlusToken))
                .body(data)
                .log().all()
                .when()
                .post(ORDERS_PATH)
                .then()
                .log().all();
    }


    @Step("Получение заказов конкретного пользователя")
    public static ValidatableResponse getUserOrders(String bearerPlusToken) {
        return given()
                .spec(getSpec(bearerPlusToken))
                .log().all() // Вывод запроса в лог
                .when()
                .get(ORDERS_PATH)
                .then()
                .log().all();
    }

}

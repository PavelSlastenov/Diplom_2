package client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.LoginUser;
import models.RegisterUser;

import static io.restassured.RestAssured.given;

public class UserClient extends Client{

    private final static String REGISTER_USER_PATH = "api/auth/register";
    private final static String LOGIN_USER_PATH = "api/auth/login";
    private final static String UPDATE_USER_PATH = "api/auth/user";

    @Step("Создание пользователя")
    public static ValidatableResponse registerUser(RegisterUser data) {
        return given()
                .spec(getSpec())
                .body(data)
                .log().all()
                .when()
                .post(REGISTER_USER_PATH)
                .then()
                .log().all();
    }

    @Step("Логин пользователя")
    public static ValidatableResponse loginUser(LoginUser data) {
        return given()
                .spec(getSpec())
                .body(data)
                .log().all()
                .when()
                .post(LOGIN_USER_PATH)
                .then()
                .log().all();
    }

    @Step("Изменение данных пользователя")
    public static  ValidatableResponse updateUser(RegisterUser data, String bearerPlusToken) {
        return given()
                .spec(getSpec(bearerPlusToken))
                .body(data)
                .log().all()
                .when()
                .patch(UPDATE_USER_PATH)
                .then()
                .log().all();
    }

    @Step("Удаление пользователя")
    public static ValidatableResponse deleteUser(String bearerPlusToken) {
        return given()
                .spec(getSpec(bearerPlusToken))
                .when()
                .log().all()
                .delete(UPDATE_USER_PATH)
                .then()
                .log().all();
    }

}
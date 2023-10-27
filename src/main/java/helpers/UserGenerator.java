package helpers;

import models.LoginUser;
import models.RegisterUser;

import static helpers.DataGenerator.randomString;

public class UserGenerator {
    final static String DEFAULT_EMAIL = randomString(8) + "@" + randomString(4) + ".ru";
    final static String DEFAULT_PASSWORD = randomString(10);
    final static String DEFAULT_NAME = randomString(6);
    final static String FAKE_EMAIL = randomString(8) + "@" + randomString(4) + "." + randomString(3);
    final static String NEW_EMAIL = randomString(8) + DEFAULT_EMAIL;
    final static String NEW_PASSWORD = randomString(8);
    final static String NEW_NAME = randomString(6);

    public enum UserField {
        EMAIL,
        PASSWORD,
        NAME
    }

    public static RegisterUser getDefaultRegistrationData() {
        return new RegisterUser(DEFAULT_EMAIL, DEFAULT_PASSWORD, DEFAULT_NAME);
    }

    public static RegisterUser getRegistrationDataWithOneEmptyField(UserField emptyField) {
        RegisterUser data = null;
        switch (emptyField) {
            case EMAIL:
                data = new RegisterUser("", DEFAULT_PASSWORD, DEFAULT_NAME);
                break;
            case PASSWORD:
                data = new RegisterUser(DEFAULT_EMAIL, "", DEFAULT_NAME);
                break;
            case NAME:
                data = new RegisterUser(DEFAULT_EMAIL, DEFAULT_PASSWORD, "");
                break;
        }
        return data;
    }

    public static LoginUser getDefaultLoginData() {
        return new LoginUser(DEFAULT_EMAIL, DEFAULT_PASSWORD);
    }

    public static LoginUser getNewLoginData() {
        return new LoginUser(NEW_EMAIL, DEFAULT_PASSWORD);
    }

    public static LoginUser getFakeLoginData() {
        return new LoginUser(FAKE_EMAIL, DEFAULT_PASSWORD);
    }

    public static RegisterUser getDefaultUpdateData() {
        return new RegisterUser(NEW_EMAIL, NEW_PASSWORD, NEW_NAME);
    }
}

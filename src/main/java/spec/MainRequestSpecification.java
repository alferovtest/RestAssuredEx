package spec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Optional;

public class MainRequestSpecification {

    private static final RequestSpecification requestSpec;

    static {
        String uri = Optional.ofNullable(System.getProperty("environmentName"))
                .map(env -> env.equals("stage")
                        ? "https://stage.com"
                        : "http://3.68.165.45")
                .orElse("http://3.68.165.45");

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType(ContentType.JSON)
                .build()
                .filter(new AllureRestAssured());
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }
}

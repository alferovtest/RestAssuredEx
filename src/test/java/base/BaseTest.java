package base;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public static ThreadLocal<SoftAssert> SOFTLY = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        SOFTLY.set(new SoftAssert());
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        SOFTLY.remove();
    }
}

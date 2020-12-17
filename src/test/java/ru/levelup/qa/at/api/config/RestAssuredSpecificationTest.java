package ru.levelup.qa.at.api.config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredSpecificationTest {

    @BeforeClass
    public void setUp() {
        try {
            RestAssuredConfig restAssuredConfig = RestAssuredConfig.newConfig()
                    .logConfig(new LogConfig(new PrintStream(("target/log.txt")), true));
            RestAssured.config = restAssuredConfig;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://restful-booker.herokuapp.com/booking")
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();

        // Глобальные настройки для всего RestAssured
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;

        // Настройка в рамках конкретного запроса
//        given(requestSpecification)
    }

    @Test
    public void simpleCreateRequestSpecificationTest() {
        System.out.println("simpleCreateRequestSpecificationTest");
        given()
                .body("{\n" +
                        "    \"firstname\" : \"Jim1\",\n" +
                        "    \"lastname\" : \"Brown1\",\n" +
                        "    \"totalprice\" : 111222212,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post()
                .then()
                .statusCode(200)
                .and()
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Jim1"))
                .body("booking.lastname", equalTo("Brown1"))
                .body("booking.totalprice", equalTo(111222212))
                .body("booking.depositpaid", is(true))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .body("booking.bookingdates.checkout", equalTo("2019-01-01"))
                .body("booking.additionalneeds", equalTo("Breakfast"));
    }

    @Test
    public void simpleGetRequestSpecificationTest() {
        System.out.println("simpleGetRequestSpecificationTest");
        given()
                .queryParam("firstname", "Jim")
                .when()
                .get()
                .then()
                .statusCode(200)
                .and()
                .body(greaterThan(2));
    }


}

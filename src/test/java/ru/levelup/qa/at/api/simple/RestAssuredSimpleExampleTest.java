package ru.levelup.qa.at.api.simple;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredSimpleExampleTest {

    @Test
    public void createBookingSimpleTest() {
        given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .and()
                .log().all()
                .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111222,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200)
                .and()
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Jim"))
                .body("booking.lastname", equalTo("Brown"))
                .body("booking.totalprice", equalTo(111222))
                .body("booking.depositpaid", is(true))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .body("booking.bookingdates.checkout", equalTo("2019-01-01"))
                .body("booking.additionalneeds", equalTo("Breakfast"));
    }
}

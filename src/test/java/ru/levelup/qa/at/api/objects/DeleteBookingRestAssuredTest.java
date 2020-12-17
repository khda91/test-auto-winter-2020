package ru.levelup.qa.at.api.objects;

import io.restassured.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelup.qa.at.api.ApiBaseTest;
import ru.levelup.qa.at.api.Endpoints;
import ru.levelup.qa.at.api.booking.BookingDate;
import ru.levelup.qa.at.api.booking.BookingRequest;
import ru.levelup.qa.at.api.booking.BookingResponse;
import ru.levelup.qa.at.api.booking.BookingTokenRequest;
import ru.levelup.qa.at.api.booking.BookingTokenResponse;

import static io.restassured.RestAssured.given;

public class DeleteBookingRestAssuredTest extends ApiBaseTest {

    @Test
    public void testName() {
        BookingRequest bookingRequest = new BookingRequest("Myn", "Moon", 11155.0,
                false, new BookingDate("2020-12-17", "2020-12-19"),
                "supper");

        BookingResponse bookingResponse = given()
                .body(bookingRequest)
                .when()
                .post(Endpoints.MAIN_URL)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(BookingResponse.class);

        long bookingId = bookingResponse.getBookingId();

        BookingTokenResponse tokenResponse = given()
                .body(new BookingTokenRequest("admin", "password123"))
                .when()
                .post(Endpoints.AUTH_URL)
                .then()
                .extract()
                .as(BookingTokenResponse.class);

        given()
                .header(new Header("Authorisation", "Basic " + tokenResponse.getToken()))
                .pathParam("id", bookingId)
                .when()
                .delete(Endpoints.ENTITY_URL)
                .then()
                .statusCode(200);
    }
}

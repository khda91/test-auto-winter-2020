package ru.levelup.qa.at.api.objects;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.mapper.ObjectMapperType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.api.ApiBaseTest;
import ru.levelup.qa.at.api.Endpoints;
import ru.levelup.qa.at.api.booking.BookingDate;
import ru.levelup.qa.at.api.booking.BookingRequest;
import ru.levelup.qa.at.api.booking.BookingResponse;

import static io.restassured.RestAssured.given;

public class SerializationDeserializationRestAssuredTest extends ApiBaseTest {

    @Test
    public void simpleObjectTest() {
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

        Assert.assertTrue(bookingResponse.getBookingId() > 3);
        Assert.assertEquals(bookingResponse.getBooking(), bookingRequest);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                {"Myn", "Moon", 112.0, true, "2020-12-18", "2020-12-20", "dinner"},
                {"Myn", "Moon", 112.0, true, "2020-12-18", "2020-12-20", null}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void simpleObjectDataProviderTest(String firstName, String lastName, Double totalPrice, boolean depositPaid,
                                             String checkIn, String checkOut, String additionalNeeds) {
        BookingRequest bookingRequest = new BookingRequest(firstName, lastName, totalPrice,
                depositPaid, new BookingDate(checkIn, checkOut), additionalNeeds);

        BookingResponse bookingResponse = given()
                .body(bookingRequest)
                .when()
                .post(Endpoints.MAIN_URL)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response().as(BookingResponse.class);

        Assert.assertTrue(bookingResponse.getBookingId() > 3);
        Assert.assertEquals(bookingResponse.getBooking(), bookingRequest);
    }

}

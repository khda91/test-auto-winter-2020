package ru.levelup.qa.at.api.booking;

import com.google.gson.annotations.SerializedName;

public class BookingResponse {

    @SerializedName("bookingid")
    private long bookingId;
    private BookingRequest booking;

    public BookingResponse() {
    }

    public BookingResponse(long bookingId, BookingRequest booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public BookingRequest getBooking() {
        return booking;
    }

    public void setBooking(BookingRequest booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingResponse that = (BookingResponse) o;

        if (bookingId != that.bookingId) return false;
        return booking != null ? booking.equals(that.booking) : that.booking == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (bookingId ^ (bookingId >>> 32));
        result = 31 * result + (booking != null ? booking.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}

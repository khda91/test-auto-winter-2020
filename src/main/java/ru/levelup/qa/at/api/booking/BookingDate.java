package ru.levelup.qa.at.api.booking;

import com.google.gson.annotations.SerializedName;

public class BookingDate {

    @SerializedName("checkin")
    private String checkIn;
    @SerializedName("checkout")
    private String checkOut;

    public BookingDate() {
    }

    public BookingDate(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingDate that = (BookingDate) o;

        if (checkIn != null ? !checkIn.equals(that.checkIn) : that.checkIn != null) return false;
        return checkOut != null ? checkOut.equals(that.checkOut) : that.checkOut == null;
    }

    @Override
    public int hashCode() {
        int result = checkIn != null ? checkIn.hashCode() : 0;
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookingDate{" +
                "checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                '}';
    }
}

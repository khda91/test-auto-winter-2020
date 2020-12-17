package ru.levelup.qa.at.api.booking;

import com.google.gson.annotations.SerializedName;


public class BookingRequest {

    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("totalprice")
    private Double totalPrice;
    @SerializedName("depositpaid")
    private boolean depositPaid;
    @SerializedName("bookingdates")
    private BookingDate bookingDates;
    @SerializedName("additionalneeds")
    private String additionalNeeds;

    public BookingRequest() {
    }

    public BookingRequest(String firstName, String lastName, Double totalPrice, boolean depositPaid, BookingDate bookingDates, String additionalNeeds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public BookingDate getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDate bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingRequest that = (BookingRequest) o;

        if (depositPaid != that.depositPaid) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (bookingDates != null ? !bookingDates.equals(that.bookingDates) : that.bookingDates != null) return false;
        return additionalNeeds != null ? additionalNeeds.equals(that.additionalNeeds) : that.additionalNeeds == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (depositPaid ? 1 : 0);
        result = 31 * result + (bookingDates != null ? bookingDates.hashCode() : 0);
        result = 31 * result + (additionalNeeds != null ? additionalNeeds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", totalPrice=" + totalPrice +
                ", depositPaid=" + depositPaid +
                ", bookingDates=" + bookingDates +
                ", additionalNeeds='" + additionalNeeds + '\'' +
                '}';
    }
}

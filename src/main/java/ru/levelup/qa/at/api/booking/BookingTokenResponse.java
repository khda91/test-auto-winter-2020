package ru.levelup.qa.at.api.booking;

public class BookingTokenResponse {

    private String token;

    public BookingTokenResponse() {
    }

    public BookingTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingTokenResponse that = (BookingTokenResponse) o;

        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        return token != null ? token.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BookingTokenResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}

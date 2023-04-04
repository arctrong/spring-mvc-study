package springmvcstudy2.model;

public class PhoneDto {

    private String countryCode;
    private String userNumber;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return this.getCountryCode() + "-" + this.getUserNumber();
    }
}

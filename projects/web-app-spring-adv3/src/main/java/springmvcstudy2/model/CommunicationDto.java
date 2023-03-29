package springmvcstudy2.model;

public class CommunicationDto {

    private String email;
    private PhoneDto phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhoneDto getPhone() {
        return phone;
    }

    public void setPhone(PhoneDto phone) {
        this.phone = phone;
    }
}

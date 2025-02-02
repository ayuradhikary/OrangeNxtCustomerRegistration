public class RegistrationDTO {
    private String country;
    private String mobileNumber;
    private String verificationCode;
    private String mPin;


    public RegistrationDTO(String country, String mobileNumber, String verificationCode, String mPin) {
        this.country = country;
        this.mobileNumber = mobileNumber;
        this.verificationCode = verificationCode;
        this.mPin = mPin;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getMPin() {
        return mPin;
    }

    public void setMPin(String mPin) {
        this.mPin = mPin;
    }

}

//public interface Registerable {
//    void register(String country, String mobileNumber, String verificationCode, String mPin);
//}

public interface Registerable {
    void register(RegistrationDTO registrationDTO);
}

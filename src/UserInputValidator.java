import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {

    boolean equalsCaseInSensitive(String response, String continueCheck){
        if (response == null || continueCheck == null) {
            return false;
        }
        String userResponse = response.toUpperCase();
        return (userResponse == continueCheck) || (userResponse != null && userResponse.equals(continueCheck));
    }

    boolean checkMobileNumber(String mobileNumber){
        String regex = "^98\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

    boolean checkVerificationCode(String verificationCode){
        String regex = "^[a-zA-Z0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(verificationCode);
        return matcher.matches();
    }

    boolean checkMpin(String Mpin){
        String regex = "^[a-zA-Z0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Mpin);
        return matcher.matches();
    }

    boolean equals(Object userResponse, Object continueCheck){
        if (userResponse == null || continueCheck == null) {
            return false;
        }
        return (userResponse == continueCheck) || (userResponse != null && userResponse.equals(continueCheck));
    }
}


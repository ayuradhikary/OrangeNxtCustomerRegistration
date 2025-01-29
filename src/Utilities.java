import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public interface Utilities {

    Map<String,String> details = new HashMap<String, String>();

    Scanner ob = new Scanner(System.in);

    static boolean equalsCaseInSensitive(Object response, Object continueCheck){
        if (response == null || continueCheck == null) {
            return false;
        }
        String userResponse = ((String)response).toUpperCase();
        return (userResponse == continueCheck) || (userResponse != null && userResponse.equals(continueCheck));
    }

    static boolean checkMobileNumber(String mobileNumber){
        String regex = "^98\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

    static boolean checkVerificationCode(String verificationCode){
        String regex = "^[a-zA-Z0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(verificationCode);
        return matcher.matches();
    }

    static boolean checkMpin(String Mpin){
        String regex = "^[a-zA-Z0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Mpin);
        return matcher.matches();
    }

    static boolean equals(Object userResponse, Object continueCheck){
        if (userResponse == null || continueCheck == null) {
            return false;
        }
        return (userResponse == continueCheck) || (userResponse != null && userResponse.equals(continueCheck));
    }

    static boolean getCustomerMobileNumber(){
        System.out.println("please enter your mobile number: ");
        String customerMobileNumber = ob.next();
        if(checkMobileNumber(customerMobileNumber)){
            details.put("mobileNumber",customerMobileNumber);
            return true;
        }
        else{
            return false;
        }
    }

    static boolean deviceVerification(){
        System.out.println("please enter verification code: ");
        String verificationCode = ob.next();
        System.out.println("please enter the verification code again: ");
        String verificationCodeTwo = ob.next();
        if(equals(verificationCode,verificationCodeTwo)){
            if(checkVerificationCode(verificationCodeTwo)){
                details.put("VerificationCode", verificationCodeTwo);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    static boolean getMpinAndVerify(){
        System.out.println("please enter the 4 character Mpin");
        String mpinOne = ob.next();
        System.out.println("please enter the Mpin again: ");
        String mpinTwo = ob.next();
        if(equals(mpinOne,mpinTwo)){
            if(checkMpin(mpinTwo)){
                details.put("MPin", mpinTwo);
                return true;
            }
            else{
                return false;
            }
        }else{
            System.out.println("Mpins do not match");
            return false;
        }
    }

    static boolean continueOrBreak(){
        System.out.println("Would you like to register another account?: ");
        String uResponse = ob.next();
        if(equalsCaseInSensitive(uResponse,"Y")){
            return true;
        }else if(equalsCaseInSensitive(uResponse,"N")){
            return false;
        }
        return false;
    }

    static void saveCustomerDetails(String country){
        Registration obj = new Registration();
        String customerCountry = country;
        String mobileNumber = details.get("mobileNumber");
        String verificationCode = details.get("VerificationCode");
        String mPin = details.get("MPin");
        obj.saveDetails(customerCountry,mobileNumber,verificationCode,mPin);
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class UserRegistrationService {

    static Map<String,String> details = new HashMap<String, String>();

    static Scanner ob = new Scanner(System.in);

    static boolean getCustomerMobileNumber(){
        System.out.println("please enter your mobile number: ");
        String customerMobileNumber = ob.next();
        if(ValidateUserInput.checkMobileNumber(customerMobileNumber)){
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
        if(ValidateUserInput.equals(verificationCode,verificationCodeTwo)){
            if(ValidateUserInput.checkVerificationCode(verificationCodeTwo)){
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
        if(ValidateUserInput.equals(mpinOne,mpinTwo)){
            if(ValidateUserInput.checkMpin(mpinTwo)){
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
        if(ValidateUserInput.equalsCaseInSensitive(uResponse,"Y")){
            return true;
        }else if(ValidateUserInput.equalsCaseInSensitive(uResponse,"N")){
            return false;
        }
        return false;
    }

    static void saveCustomerDetails(String country){
        FileRegistration obj = new FileRegistration();
        String mobileNumber = details.get("mobileNumber");
        String verificationCode = details.get("VerificationCode");
        String mPin = details.get("MPin");
        obj.register(country,mobileNumber,verificationCode,mPin);
    }
}

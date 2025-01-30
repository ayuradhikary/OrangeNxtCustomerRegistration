import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class UserRegistrationService {

    private Map<String,String> details = new HashMap<String, String>();

    static Scanner inputScanner = new Scanner(System.in);

    boolean getCustomerMobileNumber(){
        UserInputValidator userInputValidator = new UserInputValidator();
        System.out.println("please enter your mobile number: ");
        String customerMobileNumber = inputScanner.next();
        if(userInputValidator.checkMobileNumber(customerMobileNumber)){
            details.put("mobileNumber",customerMobileNumber);
            return true;
        }
        else{
            return false;
        }
    }

    boolean deviceVerification(){
        UserInputValidator userInputValidator = new UserInputValidator();
        System.out.println("please enter verification code: ");
        String verificationCode = inputScanner.next();
        System.out.println("please enter the verification code again: ");
        String verificationCodeTwo = inputScanner.next();
        if(userInputValidator.equals(verificationCode,verificationCodeTwo)){
            if(userInputValidator.checkVerificationCode(verificationCodeTwo)){
                details.put("VerificationCode", verificationCodeTwo);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    boolean getMpinAndVerify(){
        UserInputValidator userInputValidator = new UserInputValidator();
        System.out.println("please enter the 4 character Mpin");
        String mpinOne = inputScanner.next();
        System.out.println("please enter the Mpin again: ");
        String mpinTwo = inputScanner.next();
        if(userInputValidator.equals(mpinOne,mpinTwo)){
            if(userInputValidator.checkMpin(mpinTwo)){
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

   boolean continueOrBreak(){
        UserInputValidator userInputValidator = new UserInputValidator();
        System.out.println("Would you like to register another account?: ");
        String registerAnotherAccountResponse = inputScanner.next();
        if(userInputValidator.equalsCaseInSensitive(registerAnotherAccountResponse,"Y")){
            return true;
        }else if(userInputValidator.equalsCaseInSensitive(registerAnotherAccountResponse,"N")){
            return false;
        }
        return false;
    }

   void saveCustomerDetails(String country){
        FileRegistration obj = new FileRegistration();
        String mobileNumber = details.get("mobileNumber");
        String verificationCode = details.get("VerificationCode");
        String mPin = details.get("MPin");
        obj.register(country,mobileNumber,verificationCode,mPin);
    }
}

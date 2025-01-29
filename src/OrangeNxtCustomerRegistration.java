import java.util.Scanner;

public class OrangeNxtCustomerRegistration  {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Country.CountryEnum countryNepal = Country.CountryEnum.Nepal;
        String countryNepalString = countryNepal.name();
        Country.CountryEnum countryIndia = Country.CountryEnum.India;
        String countryIndiaString = countryIndia.name();

        UserRegistrationService userRegistrationService = new UserRegistrationService();
        UserInputValidator userInputValidator = new UserInputValidator();

        while(true){
            System.out.println("Would you like to register?(Y/N): ");
            String response = inputScanner.next();
            if(userInputValidator.equalsCaseInSensitive(response, "Y")){
                System.out.println("List of countries: ");
                System.out.println("1. " + countryNepalString + "\n" + "2. " + countryIndiaString);
                System.out.println("please choose above countries(1/2): ");
                String countryCode = inputScanner.next();
                if(userInputValidator.equalsCaseInSensitive(countryCode,"1")){

                    System.out.println("Nepal");
                    String country = "Nepal";
                    if(userRegistrationService.getCustomerMobileNumber()){
                        System.out.println("mobile number verified");
                        System.out.println("Verify this device?(Y/N): ");
                        String userMobileNumberVerificationResponse = inputScanner.next();
                        if(userInputValidator.equalsCaseInSensitive(userMobileNumberVerificationResponse, "Y")){
                            if(userRegistrationService.deviceVerification()){
                                    if(userRegistrationService.getMpinAndVerify()){
                                        userRegistrationService.saveCustomerDetails(country);
                                        System.out.println("Registration successfull");
                                        if(userRegistrationService.continueOrBreak()){
                                            continue;
                                        }else{
                                            break;
                                        }
                                    }else{
                                        System.out.println("Invalid Mpins");
                                        break;
                                    }
                            }else{
                                System.out.println("Mpin did not match. Registration failed");
                                break;
                            }
                        }else{
                            System.out.println("exiting application");
                            break;
                        }
                    }else{
                        System.out.println("Invalid mobile number");
                        break;
                    }
                } else if (userInputValidator.equalsCaseInSensitive(countryCode,"2")) {
                    System.out.println("India");
                    String country = "India";
                    if(userRegistrationService.getCustomerMobileNumber()){
                        System.out.println("mobile number verified");
                        System.out.println("Verify this device?(Y/N): ");
                        String userMobileNumberVerificationResponse = inputScanner.next();
                        if(userInputValidator.equalsCaseInSensitive(userMobileNumberVerificationResponse, "Y")){
                            if(userRegistrationService.deviceVerification()){
                                if(userRegistrationService.getMpinAndVerify()){
                                    userRegistrationService.saveCustomerDetails(country);
                                    System.out.println("Registration successfull");
                                    if (userRegistrationService.continueOrBreak()) {
                                        continue;
                                    }else{
                                        break;
                                    }
                                }else{
                                    System.out.println("Invalid Mpins");
                                    break;
                                }
                            }else{
                                System.out.println("registration failed");
                                break;
                            }
                        }else{
                            System.out.println("exiting application");
                            break;
                        }
                    }else{
                        System.out.println("Invalid mobile number");
                        break;
                    }
                }

            } else if (userInputValidator.equalsCaseInSensitive(response, "N")) {
                System.out.println("closing application .... ");
                break;
            }else{
                System.out.println("Invalid response");
                break;
            }
        }
    }
}

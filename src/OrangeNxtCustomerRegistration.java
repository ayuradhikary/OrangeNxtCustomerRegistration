import java.util.Scanner;

public class OrangeNxtCustomerRegistration  {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        Country.CountryEnum countryNepal = Country.CountryEnum.Nepal;
        String countryNepalString = countryNepal.name();
        Country.CountryEnum countryIndia = Country.CountryEnum.India;
        String countryIndiaString = countryIndia.name();

        while(true){
            System.out.println("Would you like to register?(Y/N): ");
            String response = ob.next();
            if(ValidateUserInput.equalsCaseInSensitive(response, "Y")){
                System.out.println("List of countries: ");
                System.out.println("1. " + countryNepalString + "\n" + "2. " + countryIndiaString);
                System.out.println("please choose above countries(1/2): ");
                String countryCode = ob.next();
                if(ValidateUserInput.equalsCaseInSensitive(countryCode,"1")){

                    System.out.println("Nepal");
                    String country = "Nepal";
                    if(UserRegistrationService.getCustomerMobileNumber()){
                        System.out.println("mobile number verified");
                        System.out.println("Verify this device?(Y/N): ");
                        String userResponse = ob.next();
                        if(ValidateUserInput.equalsCaseInSensitive(userResponse, "Y")){
                            if(UserRegistrationService.deviceVerification()){
                                    if(UserRegistrationService.getMpinAndVerify()){
                                        UserRegistrationService.saveCustomerDetails(country);
                                        System.out.println("Registration successfull");
                                        if(UserRegistrationService.continueOrBreak()){
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
                } else if (ValidateUserInput.equalsCaseInSensitive(countryCode,"2")) {
                    System.out.println("India");
                    String country = "India";
                    if(UserRegistrationService.getCustomerMobileNumber()){
                        System.out.println("mobile number verified");
                        System.out.println("Verify this device?(Y/N): ");
                        String userResponse = ob.next();
                        if(ValidateUserInput.equalsCaseInSensitive(userResponse, "Y")){
                            if(UserRegistrationService.deviceVerification()){
                                if(UserRegistrationService.getMpinAndVerify()){
                                    UserRegistrationService.saveCustomerDetails(country);
                                    System.out.println("Registration successfull");
                                    if (UserRegistrationService.continueOrBreak()) {
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

            } else if (ValidateUserInput.equalsCaseInSensitive(response, "N")) {
                System.out.println("closing application .... ");
                break;
            }else{
                System.out.println("Invalid response");
                break;
            }
        }
    }
}

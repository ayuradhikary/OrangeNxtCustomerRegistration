
import jdk.jshell.execution.Util;

import java.util.Scanner;

public class Main implements Utilities {
    enum AllCountries {
        Nepal,
        India
    }

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        while(true){
            System.out.println("Would you like to register?(Y/N): ");
            String response = ob.next();
            if(Utilities.equalsCaseInSensitive(response, "Y")){
                System.out.println("List of countries: ");
                int counter = 1;
                for (AllCountries country : AllCountries.values()) {
                        System.out.println(counter+"."+country);
                        counter++;
                }
                System.out.println("please choose above countries(1/2): ");
                String countryCode = ob.next();
                if(Utilities.equalsCaseInSensitive(countryCode,"1")){

                    System.out.println("Nepal");
                    String country = "Nepal";
                    if(Utilities.getCustomerMobileNumber()){
                        System.out.println("mobile number verified");
                        System.out.println("Verify this device?(Y/N): ");
                        String userResponse = ob.next();
                        if(Utilities.equalsCaseInSensitive(userResponse, "Y")){
                            if(Utilities.deviceVerification()){
                                    if(Utilities.getMpinAndVerify()){
                                        Utilities.saveCustomerDetails(country);
                                        System.out.println("Registration successfull");
                                        if(Utilities.continueOrBreak()){
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
                } else if (Utilities.equalsCaseInSensitive(countryCode,"2")) {
                    System.out.println("India");
                    String country = "India";
                    if(Utilities.getCustomerMobileNumber()){
                        System.out.println("mobile number verified");
                        System.out.println("Verify this device?(Y/N): ");
                        String userResponse = ob.next();
                        if(Utilities.equalsCaseInSensitive(userResponse, "Y")){
                            if(Utilities.deviceVerification()){
                                if(Utilities.getMpinAndVerify()){
                                    Utilities.saveCustomerDetails(country);
                                    System.out.println("Registration successfull");
                                    if (Utilities.continueOrBreak()) {
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

            } else if (Utilities.equalsCaseInSensitive(response, "N")) {
                System.out.println("closing application .... ");
                break;
            }else{
                System.out.println("Invalid response");
                break;
            }
        }
    }
}

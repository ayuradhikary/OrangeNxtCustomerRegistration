import java.io.*;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;

public class FileRegistration implements Registerable{
    private Map<String,String> details = new HashMap<>();
    private final String registration_FILE = "registrationdetails.txt";
    File file = new File(registration_FILE);

    @Override
    public void register(String country, String mobileNumber, String verificationCode, String mPin) {
        details.put("country",country);
        details.put("mobileNumber", mobileNumber);
        details.put("VerificationCode", verificationCode);
        details.put("MPin", mPin);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(registration_FILE, true))){
         /*   String message = "New Customer from %s " + details.get("country") +
                    " with mobile number " + details.get("mobileNumber") +
                    " is registered with verification code " + details.get("VerificationCode") +
                    " and he/she has set mpin " + details.get("MPin");*/

           String message = """ 
            New Customer from %s with mobile number  %s is registered with 
            verification code  %s and he/she has set mpin %s 
            """;

            String formattedMessage = message.formatted(details.get("country"),
                    details.get("mobileNumber"),details.get("VerificationCode"),
                    details.get("MPin"));
            writer.write(formattedMessage);
            writer.newLine();

            System.out.println(formattedMessage);
        }catch (IOException e){
            System.out.println("could not write to the file");
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;

public class FileRegistration implements Registerable{
    private Map<String,String> details = new HashMap<String, String>();
    private final String registration_FILE = "registrationdetails.txt";
    File file = new File(registration_FILE);

    @Override
    public void register(String country, String mobileNumber, String verificationCode, String mPin) {
        details.put("country",country);
        details.put("mobileNumber", mobileNumber);
        details.put("VerificationCode", verificationCode);
        details.put("MPin", mPin);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(registration_FILE, true))){
            String message = "New Customer from " + details.get("country") +
                    " with mobile number " + details.get("mobileNumber") +
                    " is registered with verification code " + details.get("VerificationCode") +
                    " and he/she has set mpin " + details.get("MPin");
            writer.write(message);
            writer.newLine();
            System.out.println(message);
        }catch (IOException e){
            System.out.println("could not write to the file");
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;

public class FileRegistration implements Registerable{
    private Map<String,String> details = new HashMap<>();
    private final String registration_FILE = "registrationdetails.txt";
    File file = new File(registration_FILE);

    @Override
    public void register(RegistrationDTO registrationDTO) {
        details.put("country",registrationDTO.getCountry());
        details.put("mobileNumber", registrationDTO.getMobileNumber());
        details.put("VerificationCode", registrationDTO.getVerificationCode());
        details.put("MPin", registrationDTO.getMPin());

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(registration_FILE, true))){

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

package pl.edu.pw.mchtr.ipr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.mchtr.ipr.user.User;
import pl.edu.pw.mchtr.ipr.user.UserRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ApiController {

    public static class UserDTO {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        private String name;
        private String country;
        private String birthDate;



        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    '}';
        }
    }

    @GetMapping("/api/{user}/searchUser")
    @ResponseBody
    public ResponseEntity<String> searchUser(
            @PathVariable String user,
            @RequestParam(name = "withString") String searchString) {
        Session session = ServiceManager.getInstance().getUserSession(user);
        if (session == null){
            ResponseEntity.notFound();
        }
        List<String> userNames = session.getSessionController().searchUser("\""+searchString+"\"");
        String jsonResult = userNames.toString();
        return ResponseEntity.ok(jsonResult);
    }

    @PutMapping("/api/users/{user}")
    public ResponseEntity<String> updateUserDescription(@PathVariable String user, @RequestBody String requestBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UserDTO updatedUser = objectMapper.readValue(requestBody, UserDTO.class);
            User tempUser = new User(user);
            tempUser.setName(updatedUser.name);
            tempUser.setCountry(updatedUser.country);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                var birthdate = sdf.parse(updatedUser.birthDate);
                tempUser.setBirthDate(birthdate);
                UserRepository.updateUser(tempUser);
            } catch (ParseException e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("Invalid date format");
            }
            String response = "User ID: " + user + "\nUpdated User: " + updatedUser.toString();
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid JSON format");
        }
    }
}

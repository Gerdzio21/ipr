package pl.edu.pw.mchtr.ipr;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApiController {
    @GetMapping("/api/{user}/searchUser")
    @ResponseBody
    public ResponseEntity<String> searchUser(
            @PathVariable String user,
            @RequestParam(name = "withString") String searchString) {
        String jsonResult = "[\"User1\", \"User2\", \"User3\"]";

        return ResponseEntity.ok(jsonResult);
    }

    @PutMapping("/api/users/{user}")
    public ResponseEntity<String> updateUserDescription(@PathVariable String user, @RequestBody String description) {

        String response = "User ID: " + user + "\nUpdated Description: " + description;

        return ResponseEntity.ok(response);
    }
}

package pl.edu.pw.mchtr.ipr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "games";
    }

    @GetMapping("/{user}/shop")
    public String storePage(@PathVariable String user, Model model) {
        model.addAttribute("user", user);
        return "store";
    }

    @GetMapping("/{user}/games")
    public String gamesPage() {
        return "games";
    }

    @GetMapping("/{user}/messages")
    public String messagesPage(@PathVariable String user, Model model) {
        model.addAttribute("user", user);
        return "messages";
    }

    @GetMapping("/{user}/info")
    public String profilePage(@PathVariable String user, Model model) {
        model.addAttribute("user", user);
        return "info";
    }

    @GetMapping("/{user}/shop/history")
    public String storeHistoryPage(@PathVariable String user, Model model) {
        String jsonResult = "{ \"history\": [\"event1\", \"event2\", \"event3\"] }";
        model.addAttribute("user", user);
        model.addAttribute("jsonResult", jsonResult);

        return "store_history";
    }
}
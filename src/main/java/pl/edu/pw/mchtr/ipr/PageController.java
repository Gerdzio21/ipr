package pl.edu.pw.mchtr.ipr;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import pl.edu.pw.mchtr.ipr.user.User;
import pl.edu.pw.mchtr.ipr.user.UserSaver;

import java.util.Map;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "games";
    }

    @GetMapping("/getSession")
    public RedirectView getSession(
            @RequestParam(name = "userName") String userName) {
        ServiceManager.getInstance().createNewSession(userName);
        UserSaver.getInstance().saveUser(new User(userName));
        return new RedirectView("/"+userName+"/games");
    }

    @GetMapping("/{user}/shop")
    public String storePage(@PathVariable String user, Model model) {
        Session session = ServiceManager.getInstance().getUserSession(user);
        model.addAttribute("user", user);
        if (session == null){
            return "error";
        }
        return "store";
    }

    @GetMapping("/{user}/games")
    public String gamesPage(@PathVariable String user, Model model) {
        Session session = ServiceManager.getInstance().getUserSession(user);
        model.addAttribute("user", user);
        if (session == null){
            return "error";
        }
        return "games";
    }

    @GetMapping("/{user}/messages")
    public String messagesPage(@PathVariable String user, Model model) {
        Session session = ServiceManager.getInstance().getUserSession(user);
        model.addAttribute("user", user);
        if (session == null){
            return "error";
        }
        return "messages";
    }

    @GetMapping("/{user}/info")
    public String profilePage(@PathVariable String user, Model model) {
        Session session = ServiceManager.getInstance().getUserSession(user);
        model.addAttribute("user", user);
        if (session == null){
            return "error";
        }
        var userData  = session.getSessionController().getInfo(user);
        model.addAttribute("userData", formatJson(userData));
        return "info";
    }

    private String formatJson(Map<String, String> map) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

    @GetMapping("/{user}/shop/history")
    public String storeHistoryPage(@PathVariable String user, Model model) {
        Session session = ServiceManager.getInstance().getUserSession(user);
        model.addAttribute("user", user);
        if (session == null){
            return "error";
        }
        String jsonResult = "tutaj historia transakcji";
        model.addAttribute("jsonResult", jsonResult);
        return "store_history";
    }
}
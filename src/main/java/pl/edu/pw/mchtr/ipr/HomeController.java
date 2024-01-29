package pl.edu.pw.mchtr.ipr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Witaj na mojej prostej stronie!");
        return "home";
    }
}

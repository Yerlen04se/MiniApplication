package intern.dev.App.controller;

import intern.dev.App.entity.Request;
import intern.dev.App.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    RequestService requestService;

    public HomeController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/")
    public String showHome(Model model) {

        Request request = new Request();

        model.addAttribute("request", request);

        return "home";
    }

    @PostMapping("/saveRequest")
    public String saveUser(@ModelAttribute("request") Request request) {

        requestService.save(request);

        return "redirect:/";

    }

    @GetMapping("/accessDeny")
    public String showAccessDeniedPage() {

        return "access-denied";
    }


}

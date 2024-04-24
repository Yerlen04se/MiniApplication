package intern.dev.App.controller;

import intern.dev.App.entity.Request;
import intern.dev.App.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RequestController {

    RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/listOfRequests")
    public String showListOfRequest(Model model) {

        List<Request> requests = requestService.getAllRequests();

        model.addAttribute("requests", requests);

        return "list-requests";
    }

}

package intern.dev.App.controller;

import intern.dev.App.entity.Role;
import intern.dev.App.entity.User;
import intern.dev.App.service.RoleService;
import intern.dev.App.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private UserService userService;

    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/listOfUsers")
    public String listUsers(Model model) {

        List<User> theUsers = userService.findAll();

        model.addAttribute("users", theUsers);

        return "list-users";

    }

    @GetMapping("/@{login_id}")
    public ResponseEntity<User> getSingleUser(@PathVariable String login_id) {
        return new ResponseEntity<User>(userService.findById(login_id), HttpStatus.OK);
    }

    @GetMapping("/register")
    public String save(Model model) {

        User user = new User();

        model.addAttribute("user", user);

        return "register";

    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {

        if(user.getPassword().trim().equals(user.getRepeatedPassword().trim()) && (user.getPassword().trim().length() > 6)) {

            userService.save(user);

            Role role = new Role(user.getLoginId());

            roleService.save(role);

            return "redirect:/";
        }
        else {

            return "/register";
        }

    }


}

package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model, @RequestParam(name = "id", required = false) Integer id) {
        if (id != null) {
            model.addAttribute("users", userService.getUserDetail(id));
            model.addAttribute("check", false);
        } else {
            model.addAttribute("check", true);
            model.addAttribute("users", userService.getUsers());
        }
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserDetails(@ModelAttribute("user") User user,
                                 Model model) {
        model.addAttribute("user", userService.getUserDetail(user.getId()));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(Model model,
                           @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUserDetail(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user
    ) {
        userService.update(user.getId(), user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user);
        return "redirect:/users";
    }


}
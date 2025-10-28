package beginner.todo.list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import beginner.todo.list.model.User;
import beginner.todo.list.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class UserControllerTemplate {
    private UserRepository userRepo;

    public UserControllerTemplate(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("title", "Scemo chi legge!");
        model.addAttribute("user", new User());
        return "register_figo";
    }
     
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        userRepo.save(user);
        model.addAttribute("user", user);
        return "page_welcome";
    }
    
}

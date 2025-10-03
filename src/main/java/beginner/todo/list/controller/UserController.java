package beginner.todo.list.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import beginner.todo.list.repository.UserRepository;
import beginner.todo.list.model.User;
import java.util.List;

@RestController
public class UserController {
    private UserRepository UserRepository;

    public UserController(UserRepository repo){
        this.UserRepository = repo;
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return UserRepository.findAll();
    }

    @PostMapping("/users")
    String addUser(@RequestBody User user) {
        if (user.getUsername() != null && user.getEmail() != null){
            UserRepository.save(user);
            return "Value savede saccessfully";
        }
        return "ERRORER: Username or email is null"; 
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (UserRepository.existsById(id)){
            UserRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "ERROR: User with id " + id + " does not exist";
    }
}

package beginner.todo.list.controller;

import org.springframework.web.bind.annotation.RestController;

import beginner.todo.list.repository.HabitsRepository;
import beginner.todo.list.model.Habit;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HabitsController {
    private HabitsRepository habitsRepo;

    public HabitsController(HabitsRepository repo){
        this.habitsRepo = repo;
    }

    @GetMapping("/habits")
    List<Habit> getHabits() {
        return habitsRepo.findAll();
    }
    
    @PostMapping("/habits")
    String addHabit(@RequestBody Habit habit) {
        if (habit.getName() != null && habit.getFrequency() != null){
            habitsRepo.save(habit);
            return "Value savede saccessfully";
        }
        return "ERRORER: Name, frequency or start date is null"; 
    }

    @DeleteMapping("/habit/{id}")
    String deleteHabit(@PathVariable Long id) {
        if (habitsRepo.existsById(id)){
            habitsRepo.deleteById(id);
            return "Habit deleted successfully";
        }
        return "ERROR: Habit with id " + id + " does not exist";
    }
}

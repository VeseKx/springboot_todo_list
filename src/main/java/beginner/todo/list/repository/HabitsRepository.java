package beginner.todo.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beginner.todo.list.model.Habit;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface HabitsRepository extends JpaRepository<Habit, Long> {
    List <Habit> findByName(String name);
    List <Habit> findByFrequency(String frequency);
    List <Habit> findByStartDate(LocalDate startDate);
}

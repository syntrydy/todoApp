package cm.gasmyr.mougang.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.todo.core.Task;

@Repository
public interface TodoRepository extends JpaRepository<Task, Long> {
}

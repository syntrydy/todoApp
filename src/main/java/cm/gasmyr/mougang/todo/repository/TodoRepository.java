package cm.gasmyr.mougang.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.todo.core.Task;

@Repository
public interface TodoRepository extends JpaRepository<Task, Long> {
	
	@Query("Select t from Task t where t.name like %:text%")
	List<Task> findTaskContaining(@Param("text")String text);
}

package cm.gasmyr.mougang.todo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.todo.core.Task;

@Service
public interface TodoService {

	public void addTask(Task task);

	public void deleteTask(Task task);

	public void deleteTask(Long id);

	public void updateTask(Task task);
	
	public Task getById(Long id);

	List<Task> getAllTasks();

	public Page<Task> findAll(Pageable pageable);

	public void updateTask(Long b);

	List<Task> searchTaskByTest(String text);

}

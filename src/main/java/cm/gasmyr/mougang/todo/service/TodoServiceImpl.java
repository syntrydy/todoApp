package cm.gasmyr.mougang.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.todo.core.Task;
import cm.gasmyr.mougang.todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	TodoRepository todoRepository;

	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public void addTask(Task task) {
		todoRepository.save(task);
	}

	@Override
	public void deleteTask(Task task) {
		todoRepository.delete(task);
	}

	@Override
	public void updateTask(Task task) {
		Task taskToUpdate = todoRepository.getOne(task.getId());
		taskToUpdate.updateInternal(task);
		todoRepository.save(taskToUpdate);
	}

	@Override
	public void deleteTask(Long id) {
		todoRepository.delete(id);

	}

	@Override
	public List<Task> getAllTasks() {
		return todoRepository.findAll();
	}

	@Override
	public Task getById(Long id) {
		return todoRepository.getOne(id);
	}

	@Override
	public Page<Task> findAll(Pageable pageable) {
		return todoRepository.findAll(pageable);
	}

	@Override
	public void updateTask(Long id) {
		Task task=todoRepository.getOne(id);	
		task.setIscomplete(true);
		todoRepository.save(task);
	}

}

package cm.gasmyr.mougang.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cm.gasmyr.mougang.todo.core.Search;
import cm.gasmyr.mougang.todo.core.Task;
import cm.gasmyr.mougang.todo.service.TodoService;

@Controller
@RequestMapping("/")
public class TodoController {

	private TodoService service;

	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToListsPage(Model model) {
		List<Task> tasks = service.getAllTasks();
		model.addAttribute("tasks", tasks);
		model.addAttribute("search", new Search());
		return "todoListPage";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String goToListPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model, Pageable pageable) {
		pageable = new PageRequest(page, size, new Sort("id"));
		model.addAttribute("tasks", service.findAll(pageable));
		model.addAttribute("search", new Search());
		return "todoListPage";
	}

	@RequestMapping("/end/{id}")
	public String goToDetailPage(Model model, @PathVariable Long id) {
		service.updateTask(id);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{id}")
	public String deleteAndGotoListPage(Model model, @PathVariable Long id) {
		service.deleteTask(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String goToUpdatePage(Model model, @PathVariable Long id) {
		model.addAttribute("task", service.getById(id));
		return "updatePage";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateTask(@Valid Task task, @PathVariable Long id, BindingResult bindingResult) {
		Task oldTask = service.getById(id);
		oldTask.updateInternal(task);
		service.addTask(oldTask);
		return "redirect:/list";
	}

	@RequestMapping(value = "/task/save", method = RequestMethod.POST)
	public String saveAndGoToList(@Valid Task task, BindingResult bindingResult, Model model) {
		service.addTask(task);
		return "redirect:/list";
	}

	@GetMapping("/task/add")
	public String gotoAddPage(Model model) {
		model.addAttribute("task", new Task());
		return "taskAddPage";
	}

	@RequestMapping(value="/task/search", method = RequestMethod.POST)
	public String searchTask(@Valid Search search,Model model) {
		System.out.println("running");
		List<Task> tasks = service.searchTaskByTest(search.getText());
		model.addAttribute("tasks", tasks);
		return "todoListPage";
	}

}

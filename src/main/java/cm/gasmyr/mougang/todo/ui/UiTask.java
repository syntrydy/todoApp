package cm.gasmyr.mougang.todo.ui;

import cm.gasmyr.mougang.todo.core.Task;

public class UiTask {
	private Long id;
	private String name;
	private String description;

	public UiTask(Long id, String name, String description) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}

	public UiTask() {

	}

	public static UiTask newInstance(Task task) {
		return new UiTask(task.getId(), task.getName(), task.getDescription());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

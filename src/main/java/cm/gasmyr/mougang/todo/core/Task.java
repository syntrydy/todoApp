package cm.gasmyr.mougang.todo.core;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "task")
public class Task extends AbstractPersistable<Long> implements Persistable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1736600041416731852L;

	public Task() {

	}

	private String name;
	private String description;
	@Version
	private Long version;
	private boolean iscomplete;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIscomplete() {
		return iscomplete;
	}

	public void setIscomplete(boolean iscomplete) {
		this.iscomplete = iscomplete;
	}

	public void updateInternal(Task task) {
		this.name = task.getName();
		this.description = task.getDescription();
		this.iscomplete=task.iscomplete;
	}
	

}

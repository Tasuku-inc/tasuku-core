package ru.mephi.tasuku.task.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.security.SecurityUser;
import ru.mephi.tasuku.task.repository.TaskRepository;
import ru.mephi.tasuku.task.repository.model.TaskModel;
import ru.mephi.tasuku.task.repository.model.TaskStatus;
import ru.mephi.tasuku.task.service.exception.TaskIdNotFoundException;
import ru.mephi.tasuku.task.service.exception.TaskNameExistsException;
import ru.mephi.tasuku.task.service.object.Task;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;

	public List<Task> findAllInProject(long projectId) {
		return taskRepository.getAllByProjectId(projectId)
				.stream().map(TaskModelMapper::modelToObject)
				.toList();
	}

	public Task getById(long taskId) {
		TaskModel taskModel = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskIdNotFoundException(taskId));
		return TaskModelMapper.modelToObject(taskModel);
	}

	@Transactional
	public long createTask(Task task) {
		if (isNameOccupied(task.getName())) {
			throw new TaskNameExistsException(task.getName());
		}

		AppUser reporter = ((SecurityUser)SecurityContextHolder
				.getContext().getAuthentication().getPrincipal()).getAppUser();
		task.setReporter(reporter);
		task.setStatus(TaskStatus.OPENED);

		TaskModel taskModel = TaskModelMapper.objectToModel(task);
		return taskRepository.save(taskModel).getId();
	}

	@Transactional
	public long updateTask(long taskId, Task updatedTask) {
		Task oldTask = this.getById(taskId);
		String oldName = oldTask.getName();
		String updatedName = updatedTask.getName();
		if (!oldName.equals(updatedName)
				&& isNameOccupied(updatedName)) {
			throw new TaskNameExistsException(updatedTask.getName());
		}

		updatedTask.setId(taskId);
		updatedTask.setProject(oldTask.getProject());

		TaskModel taskModel = TaskModelMapper.objectToModel(updatedTask);

		return taskRepository.save(taskModel).getId();
	}

	@Transactional
	public void deleteTask(long taskId) {
		if (!taskRepository.existsById(taskId)) {
			throw new TaskIdNotFoundException(taskId);
		}
		taskRepository.deleteById(taskId);
	}

	private boolean isNameOccupied(String name) {
		return taskRepository.getByName(name).isPresent();
	}
}

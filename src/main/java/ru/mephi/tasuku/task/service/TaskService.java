package ru.mephi.tasuku.task.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.security.SecurityUser;
import ru.mephi.tasuku.sprint.SprintUtils;
import ru.mephi.tasuku.task.repository.TaskRepository;
import ru.mephi.tasuku.task.repository.model.TaskModel;
import ru.mephi.tasuku.task.repository.model.TaskStatus;
import ru.mephi.tasuku.task.service.exception.TaskByIdNotFoundException;
import ru.mephi.tasuku.task.service.exception.TaskNameExistsException;
import ru.mephi.tasuku.task.service.object.Task;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;

	public List<Task> findAllInProject(long projectId) {
		return taskRepository.findAllByProjectId(projectId)
				.stream().map(TaskModelMapper::modelToObject)
				.toList();
	}

	public Task getById(long taskId) {
		TaskModel taskModel = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskByIdNotFoundException(taskId));
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
		task.setSprint(SprintUtils.getActual());

		TaskModel taskModel = TaskModelMapper.objectToModel(task);
		return taskRepository.save(taskModel).getId();
	}

	@Transactional
	public void updateTask(long taskId, Task updatedTask) {
		Task currentTask = getById(taskId);
		String currentName = currentTask.getName();
		String updatedName = updatedTask.getName();
		if (!currentName.equals(updatedName)
				&& isNameOccupied(updatedName)) {
			throw new TaskNameExistsException(updatedTask.getName());
		}

		TaskModel model = TaskModelMapper.objectToModel(updatedTask);
		taskRepository.save(model);
	}

	@Transactional
	public void deleteTask(long taskId) {
		if (!taskRepository.existsById(taskId)) {
			throw new TaskByIdNotFoundException(taskId);
		}
		taskRepository.deleteById(taskId);
	}

	private boolean isNameOccupied(String name) {
		return taskRepository.findByName(name).isPresent();
	}
}

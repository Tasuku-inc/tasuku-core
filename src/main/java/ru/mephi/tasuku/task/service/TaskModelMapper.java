package ru.mephi.tasuku.task.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.project.service.ProjectModelMapper;
import ru.mephi.tasuku.sprint.service.SprintModelMapper;
import ru.mephi.tasuku.task.repository.model.TaskModel;
import ru.mephi.tasuku.task.service.object.Task;

@Component
@RequiredArgsConstructor
public class TaskModelMapper {
	@Lazy
	@Autowired
	private AppUserModelMapper appUserModelMapper;

	@Lazy
	@Autowired
	private ProjectModelMapper projectModelMapper;
	private final SprintModelMapper sprintModelMapper;

	public Task modelToObject(TaskModel model) {
		return Task.builder()
				.id(model.getId())
				.name(model.getName())
				.reporter(appUserModelMapper.modelToObject(model.getReporter()))
				.assignee(appUserModelMapper.modelToObject(model.getAssignee()))
				.status(model.getStatus())
				.description(model.getDescription())
				.sprint(sprintModelMapper.modelToObject(model.getSprint()))
				.project(projectModelMapper.modelToObject(model.getProject()))
				.build();
	}

	public TaskModel objectToModel(Task object) {
		return TaskModel.builder()
				.id(object.getId())
				.name(object.getName())
				.reporter(appUserModelMapper.objectToModel(object.getReporter()))
				.assignee(appUserModelMapper.objectToModel(object.getReporter()))
				.description(object.getDescription())
				.sprint(sprintModelMapper.objectToModel(object.getSprint()))
				.project(projectModelMapper.objectToModel(object.getProject()))
				.build();
	}

}

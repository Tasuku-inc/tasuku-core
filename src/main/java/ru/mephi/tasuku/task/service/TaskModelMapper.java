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
public class TaskModelMapper {

	public static Task modelToObject(TaskModel model) {
		return Task.builder()
				.id(model.getId())
				.name(model.getName())
				.reporter(AppUserModelMapper.modelToObject(model.getReporter()))
				.assignee(AppUserModelMapper.modelToObject(model.getAssignee()))
				.status(model.getStatus())
				.description(model.getDescription())
				.sprint(SprintModelMapper.modelToObject(model.getSprint()))
				.project(ProjectModelMapper.modelToObject(model.getProject()))
				.build();
	}

	public static TaskModel objectToModel(Task object) {
		return TaskModel.builder()
				.id(object.getId())
				.name(object.getName())
				.reporter(AppUserModelMapper.objectToModel(object.getReporter()))
				.assignee(AppUserModelMapper.objectToModel(object.getReporter()))
				.description(object.getDescription())
				.sprint(SprintModelMapper.objectToModel(object.getSprint()))
				.project(ProjectModelMapper.objectToModel(object.getProject()))
				.build();
	}
}

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
		var object = Task.builder()
				.id(model.getId())
				.name(model.getName())
				.reporter(AppUserModelMapper.modelToObject(model.getReporter()))
				.assignee(AppUserModelMapper.modelToObject(model.getAssignee()))
				.status(model.getStatus())
				.description(model.getDescription())
				.project(ProjectModelMapper.modelToObject(model.getProject()));

		if (model.getSprint() != null) {
			object.sprint(SprintModelMapper.modelToObject(model.getSprint()));
		}

		return object.build();
	}

	public static TaskModel objectToModel(Task object) {
		var model = TaskModel.builder()
				.id(object.getId())
				.name(object.getName())
				.reporter(AppUserModelMapper.objectToModel(object.getReporter()))
				.assignee(AppUserModelMapper.objectToModel(object.getAssignee()))
				.status(object.getStatus())
				.description(object.getDescription())
				.project(ProjectModelMapper.objectToModel(object.getProject()));

		if (object.getSprint() != null) {
			model.sprint(SprintModelMapper.objectToModel(object.getSprint()));
		}

		return model.build();
	}
}

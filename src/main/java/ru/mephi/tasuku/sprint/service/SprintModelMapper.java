package ru.mephi.tasuku.sprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.project.service.ProjectModelMapper;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;
import ru.mephi.tasuku.sprint.service.object.Sprint;
import ru.mephi.tasuku.task.service.TaskModelMapper;

import java.util.stream.Collectors;

@Component
public class SprintModelMapper {
	@Lazy
	@Autowired
	private ProjectModelMapper projectModelMapper;
	@Lazy
	@Autowired
	private TaskModelMapper taskModelMapper;

	public Sprint modelToObject(SprintModel model) {
		return Sprint.builder()
				.id(model.getId())
				.fromDate(model.getFromDate())
				.toDate(model.getToDate())
				.project(projectModelMapper.modelToObject(model.getProject()))
				.tasks(model.getTasks()
						.stream()
						.map(taskModelMapper::modelToObject)
						.collect(Collectors.toList()))
				.build();
	}

	public SprintModel objectToModel(Sprint object) {
		return SprintModel.builder()
				.id(object.getId())
				.fromDate(object.getFromDate())
				.toDate(object.getToDate())
				.project(projectModelMapper.objectToModel(object.getProject()))
				.tasks(object.getTasks()
						.stream()
						.map(taskModelMapper::objectToModel)
						.collect(Collectors.toList()))
				.build();
	}
}

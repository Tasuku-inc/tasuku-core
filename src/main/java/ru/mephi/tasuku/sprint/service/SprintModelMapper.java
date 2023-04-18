package ru.mephi.tasuku.sprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.project.service.ProjectModelMapper;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;
import ru.mephi.tasuku.sprint.service.object.Sprint;
import ru.mephi.tasuku.task.service.TaskModelMapper;

import java.util.List;
import java.util.stream.Collectors;
public class SprintModelMapper {

	public static Sprint modelToObject(SprintModel model) {
		return Sprint.builder()
				.id(model.getId())
				.fromDate(model.getFromDate())
				.toDate(model.getToDate())
				.project(ProjectModelMapper.modelToObject(model.getProject()))
				.tasks(List.of())
				.build();
	}

	public static SprintModel objectToModel(Sprint object) {
		return SprintModel.builder()
				.id(object.getId())
				.fromDate(object.getFromDate())
				.toDate(object.getToDate())
				.project(ProjectModelMapper.objectToModel(object.getProject()))
				.tasks(List.of())
				.build();
	}
}

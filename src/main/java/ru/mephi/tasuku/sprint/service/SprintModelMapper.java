package ru.mephi.tasuku.sprint.service;

import java.util.List;

import ru.mephi.tasuku.project.service.ProjectModelMapper;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;
import ru.mephi.tasuku.sprint.service.object.Sprint;

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

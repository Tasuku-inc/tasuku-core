package ru.mephi.tasuku.task.service;

import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.project.service.ProjectModelMapper;
import ru.mephi.tasuku.sprint.service.SprintModelMapper;
import ru.mephi.tasuku.task.repository.model.TaskModel;
import ru.mephi.tasuku.task.service.object.Task;

public class TaskModelMapper {

    public static Task modelToObject(TaskModel model) {
        return Task.builder()
                .id(model.getId())
                .name(model.getName())
                .reporter(AppUserModelMapper.modelToObject(model.getReporter()))
                .assignee(AppUserModelMapper.modelToObject(model.getAssignee()))
                .status(model.getStatus())
                .description(model.getDescription())
                .project(ProjectModelMapper.modelToObject(model.getProject()))
                .sprint(SprintModelMapper.modelToObject(model.getSprint()))
                .build();
    }

    public static TaskModel objectToModel(Task object) {
        return TaskModel.builder()
                .id(object.getId())
                .name(object.getName())
                .reporter(AppUserModelMapper.objectToModel(object.getReporter()))
                .assignee(AppUserModelMapper.objectToModel(object.getAssignee()))
                .status(object.getStatus())
                .description(object.getDescription())
                .project(ProjectModelMapper.objectToModel(object.getProject()))
                .sprint(SprintModelMapper.objectToModel(object.getSprint()))
                .build();
    }
}

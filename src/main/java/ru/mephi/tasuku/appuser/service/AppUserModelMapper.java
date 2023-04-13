package ru.mephi.tasuku.appuser.service;

import java.util.List;

import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;

@Component
public class AppUserModelMapper {

    public AppUser modelToObject(AppUserModel model) {
        return AppUser.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .email(model.getEmail())
                //TODO пока что так
                .projectUserRoles(null)
                .assignedTasks(List.of())
                .reportingTasks(List.of())
                .assignedTasks(List.of())
                .build();
    }

    public AppUserModel objectToModel(AppUser object) {
        return AppUserModel.builder()
                .id(object.getId())
                .username(object.getUsername())
                .password(object.getPassword())
                .email(object.getEmail())
                //TODO пока что так
                .projectUserRoles(null)
                .assignedTasks(List.of())
                .reportingTasks(List.of())
                .assignedTasks(List.of())
                .build();
    }

}

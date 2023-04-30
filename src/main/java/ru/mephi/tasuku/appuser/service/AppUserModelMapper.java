package ru.mephi.tasuku.appuser.service;

import java.util.List;

import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.appuser.service.object.AppUser;

public class AppUserModelMapper {

    public static AppUser modelToObject(AppUserModel model) {
        return AppUser.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .email(model.getEmail())
                .systemRole(model.getSystemRole())
                .projectUserRoles(List.of())
                .assignedTasks(List.of())
                .reportingTasks(List.of())
                .build();
    }

    public static AppUserModel objectToModel(AppUser object) {
        return AppUserModel.builder()
                .id(object.getId())
                .username(object.getUsername())
                .password(object.getPassword())
                .email(object.getEmail())
                .systemRole(object.getSystemRole())
                .projectUserRoles(List.of())
                .assignedTasks(List.of())
                .reportingTasks(List.of())
                .build();
    }
}

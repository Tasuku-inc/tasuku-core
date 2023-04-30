package ru.mephi.tasuku.binding.service;

import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRoleModel;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRolePk;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;
import ru.mephi.tasuku.project.service.ProjectModelMapper;

public class ProjectUserRoleModelMapper {

    public static ProjectUserRole modelToObject(ProjectUserRoleModel model) {
        return ProjectUserRole.builder()
                .project(ProjectModelMapper.modelToObject(model.getPk().getProject()))
                .appUser(AppUserModelMapper.modelToObject(model.getPk().getAppUser()))
                .userRole(model.getUserRole())
                .build();
    }

    public static ProjectUserRoleModel objectToModel(ProjectUserRole object) {
        return ProjectUserRoleModel.builder()
                .pk(ProjectUserRolePk.builder()
                        .appUser(AppUserModelMapper.objectToModel(object.getAppUser()))
                        .project(ProjectModelMapper.objectToModel(object.getProject()))
                        .build()
                )
                .userRole(object.getUserRole())
                .build();
    }
}

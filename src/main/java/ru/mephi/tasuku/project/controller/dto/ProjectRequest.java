package ru.mephi.tasuku.project.controller.dto;

import lombok.Data;
import ru.mephi.tasuku.appuser.model.AppUserModel;

@Data
public class ProjectRequest {
    private String name;
    private AppUserModel headUser;
}

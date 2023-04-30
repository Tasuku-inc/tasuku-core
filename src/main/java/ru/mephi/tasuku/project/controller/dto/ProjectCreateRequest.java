package ru.mephi.tasuku.project.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectCreateRequest {
    @NotBlank(message = "Project name can't be blank or empty")
    @NotNull(message = "Project name can't be null")
    private String name;
    @NotNull(message = "HeadUserId can't be null")
    private Long headUserId;
}

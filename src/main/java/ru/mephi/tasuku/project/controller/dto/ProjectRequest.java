package ru.mephi.tasuku.project.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class ProjectRequest {
    private String name;
    private Long headUserId;
    private Boolean closed;
}

package ru.mephi.tasuku.project.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {
    private Long id;
    private String name;
    private boolean closed;
    private String headUsername;
}

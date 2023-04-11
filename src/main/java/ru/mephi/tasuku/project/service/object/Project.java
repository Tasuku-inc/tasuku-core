package ru.mephi.tasuku.project.service.object;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Project {
    private long id;
    private String name;
    private boolean closed;
//TODO требуется реализация следующих полей
//    private AppUser headUser;
//    private List<ProjectUserRole> projectUserRoles;
//    private List<Task> taskModels;
//    private List<Sprint> sprints;
}

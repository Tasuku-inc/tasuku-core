package ru.mephi.tasuku.project.service.object;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ru.mephi.tasuku.appuser.model.AppUserModel;

@Data
@Builder
@ToString
public class Project {
    private long id;
    private String name;
    private AppUserModel headUser;
    private boolean closed;
//TODO требуется реализация следующих полей
//    private List<ProjectUserRole> projectUserRoles;
//    private List<Task> taskModels;
//    private List<Sprint> sprints;
}

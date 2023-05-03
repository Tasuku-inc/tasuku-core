package ru.mephi.tasuku.project.service.object;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;
import ru.mephi.tasuku.sprint.service.object.Sprint;
import ru.mephi.tasuku.task.service.object.Task;

@Data
@Builder
@ToString
public class Project {
    private Long id;
    private String name;
    private Boolean closed;
    private AppUser headUser;
    private List<ProjectUserRole> projectUserRoles;
    private List<Task> tasks;
    private List<Sprint> sprints;

    public Boolean isClosed() {
        return closed;
    }
}

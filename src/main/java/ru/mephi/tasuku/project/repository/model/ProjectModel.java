package ru.mephi.tasuku.project.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mephi.tasuku.appuser.model.AppUserModel;
import ru.mephi.tasuku.binding.model.ProjectUserRoleModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.mephi.tasuku.sprint.model.SprintModel;
import ru.mephi.tasuku.task.model.TaskModel;

import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {
        "projectUserRoles",
        "tasks",
        "sprints"
})
@ToString(exclude = {
        "projectUserRoles",
        "tasks",
        "sprints"
})
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "head_user_id")
    private AppUserModel headUser;
    @Column
    private boolean closed;
    @OneToMany(mappedBy = "pk.project", cascade = CascadeType.ALL)
    private List<ProjectUserRoleModel> projectUserRoles;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TaskModel> tasks;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SprintModel> sprints;
}

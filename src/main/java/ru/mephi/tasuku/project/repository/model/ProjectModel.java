package ru.mephi.tasuku.project.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mephi.tasuku.appuser.model.AppUserModel;
import ru.mephi.tasuku.binding.ProjectUserRoleModel;
import ru.mephi.tasuku.sprint.model.SprintModel;
import ru.mephi.tasuku.task.model.TaskModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {
        "projectUserRoles",
        "taskModels",
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
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "pk.project", cascade = CascadeType.ALL)
    private List<ProjectUserRoleModel> projectUserRoles;
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TaskModel> taskModels;
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SprintModel> sprints;
}

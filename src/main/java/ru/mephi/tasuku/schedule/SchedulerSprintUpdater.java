package ru.mephi.tasuku.schedule;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.mephi.tasuku.project.service.ProjectService;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.SprintUtils;
import ru.mephi.tasuku.sprint.service.object.Sprint;
import ru.mephi.tasuku.task.repository.model.TaskStatus;
import ru.mephi.tasuku.task.service.TaskService;
import ru.mephi.tasuku.task.service.object.Task;

@Slf4j
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerSprintUpdater {

    private final ProjectService projectService;
    private final TaskService taskService;

    @Scheduled(cron = "@weekly")
    public void sprintUpdate() {
        log.info("Schedule task for sprint started!");
        List<Project> projects = projectService.getAll();

        for (Project project : projects) {
            List<Sprint> sprints = project.getSprints();
            Sprint lastSprint = SprintUtils.getLast(sprints);
            Sprint actualSprint = SprintUtils.getActual();
            sprints.add(actualSprint);

            List<Task> tasks = taskService.findAllInProject(project.getId());

            processing(tasks, lastSprint, actualSprint);

            tasks.forEach(task -> taskService.updateTask(task.getId(), task));
            projectService.updateProject(project.getId(), project);
        }

        log.info("Schedule task for sprint finished!");
    }

    private void processing(List<Task> tasks, Sprint lastSprint, Sprint actualSprint) {
        List<Task> openTasks = tasks.stream()
                .filter(task -> task.getStatus() != TaskStatus.FINISHED)
                .peek(task -> task.setSprint(actualSprint))
                .toList();
        lastSprint.getTasks().removeAll(openTasks);
        actualSprint.setTasks(openTasks);
    }
}
package ru.mephi.tasuku.task.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.security.UserConditionEvaluator;
import ru.mephi.tasuku.sprint.SprintUtils;
import ru.mephi.tasuku.task.repository.TaskRepository;
import ru.mephi.tasuku.task.repository.model.TaskModel;
import ru.mephi.tasuku.task.repository.model.TaskStatus;
import ru.mephi.tasuku.task.service.exception.TaskByIdNotFoundException;
import ru.mephi.tasuku.task.service.exception.TaskNameExistsException;
import ru.mephi.tasuku.task.service.object.Task;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task getById(long taskId) {
        TaskModel taskModel = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskByIdNotFoundException(taskId));
        return TaskModelMapper.modelToObject(taskModel);
    }

    public List<Task> getAllByProjectId(long projectId) {
        return taskRepository.findAllByProjectId(projectId).stream()
                .map(TaskModelMapper::modelToObject)
                .toList();
    }

    public List<Task> getAllByAssigneeId(long appUserId) {
        return taskRepository.findAllByAssigneeId(appUserId).stream()
                .map(TaskModelMapper::modelToObject)
                .toList();
    }

    public List<Task> getAllByReporterId(long appUserId) {
        return taskRepository.findAllByReporterId(appUserId).stream()
                .map(TaskModelMapper::modelToObject)
                .toList();
    }

    public List<Task> getAllBySprintId(long sprintId) {
        return taskRepository.findAllBySprintId(sprintId).stream()
                .map(TaskModelMapper::modelToObject)
                .toList();
    }

    @Transactional
    public long createTask(Task task) {
        if (isNameExists(task.getName())) {
            throw new TaskNameExistsException(task.getName());
        }
        AppUser reporter = UserConditionEvaluator.getAuthAppUser();
        task.setReporter(reporter);
        task.setStatus(TaskStatus.OPENED);

        task.setSprint(SprintUtils.getActual());
        TaskModel taskModel = TaskModelMapper.objectToModel(task);
        return taskRepository.save(taskModel).getId();
    }

    @Transactional
    public void updateTask(Task updatedTask) {
        Task task = getById(updatedTask.getId());
        String newName = updatedTask.getName();
        if (newName != null) {
            if (isNameExists(newName)) {
                throw new TaskNameExistsException(newName);
            }
            task.setName(newName);
        }
        AppUser newAssignee = updatedTask.getAssignee();
        if (newAssignee != null) {
            task.setAssignee(newAssignee);
        }
        AppUser newReporter = updatedTask.getReporter();
        if (newReporter != null) {
            task.setAssignee(newReporter);
        }
        TaskStatus newStatus = updatedTask.getStatus();
        if (newStatus != null) {
            task.setStatus(newStatus);
        }
        String newDescription = updatedTask.getDescription();
        if (newDescription != null) {
            task.setDescription(newDescription);
        }
        TaskModel model = TaskModelMapper.objectToModel(task);
        taskRepository.save(model);
    }

    @Transactional
    public void deleteTask(long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskByIdNotFoundException(taskId);
        }
        taskRepository.deleteById(taskId);
    }

    private boolean isNameExists(String name) {
        return taskRepository.findByName(name).isPresent();
    }
}

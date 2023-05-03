package ru.mephi.tasuku.sprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.SprintUtils;
import ru.mephi.tasuku.sprint.repository.SprintRepository;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;
import ru.mephi.tasuku.sprint.service.exception.SprintIdNotFoundException;
import ru.mephi.tasuku.sprint.service.object.Sprint;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintService {
	private final SprintRepository sprintRepository;

	public Sprint getById(Long id) {
		if (id == null) {
			return null;
		}
		SprintModel sprintModel = sprintRepository.findById(id)
				.orElseThrow(() -> new SprintIdNotFoundException(id));
		return SprintModelMapper.modelToObject(sprintModel);
	}

	@Transactional
	public Sprint createActualSprintInProject(Project project) {
		Sprint sprint = SprintUtils.createActualByProject(project);
		SprintModel sprintModel = SprintModelMapper.objectToModel(sprint);
		return SprintModelMapper.modelToObject(sprintRepository.save(sprintModel));
	}

	@Transactional
	public void update(Sprint sprint) {
		SprintModel model = SprintModelMapper.objectToModel(sprint);
		sprintRepository.save(model);
	}

	public List<Sprint> getByProjectId(long projectId) {
		return sprintRepository.findByProjectIdOrderByFromDate(projectId).stream()
				.map(SprintModelMapper::modelToObject)
				.toList();
	}

	public Sprint getActualByProjectId(long projectId) {
		List<Sprint> sprints = getByProjectId(projectId);
		return sprints.get(sprints.size() - 1);
	}
}

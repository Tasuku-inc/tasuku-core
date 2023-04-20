package ru.mephi.tasuku.sprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.sprint.repository.SprintRepository;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;
import ru.mephi.tasuku.sprint.service.exception.SprintIdNotFoundException;
import ru.mephi.tasuku.sprint.service.object.Sprint;

@Service
@RequiredArgsConstructor
public class SprintService {
	private final SprintRepository sprintRepository;

	public Sprint findById(Long id) {
		if (id == null) {
			return null;
		}
		SprintModel sprintModel = sprintRepository.findById(id)
				.orElseThrow(() -> new SprintIdNotFoundException(id));
		return SprintModelMapper.modelToObject(sprintModel);
	}

}

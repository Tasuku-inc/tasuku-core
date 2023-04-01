package com.tasukuinc.tasukucore.controller;

import com.tasukuinc.tasukucore.domain.Project;
import com.tasukuinc.tasukucore.domain.ProjectRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectRepository projectRepository;

	@GetMapping("/all")
	public ResponseEntity<Iterable<Project>> getAll() {
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(projectRepository.findAll());
	}
}

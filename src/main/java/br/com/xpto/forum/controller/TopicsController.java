 package br.com.xpto.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.xpto.forum.controller.dto.TopicDetailsDto;
import br.com.xpto.forum.controller.dto.TopicDto;
import br.com.xpto.forum.controller.form.UpdateTopicForm;
import br.com.xpto.forum.controller.form.TopicForm;
import br.com.xpto.forum.model.Topic;
import br.com.xpto.forum.repository.CourseRepository;
import br.com.xpto.forum.repository.TopicRepository;

@RestController
@RequestMapping("/topicos")
public class TopicsController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public List<TopicDto> searchTopicsList(String courseName) {
		
		if (courseName==null) {
			List<Topic> topics = topicRepository.findAll();
			return TopicDto.converter(topics);
		} else {
			List<Topic> topics = topicRepository.findByCourse_Name(courseName);
			return TopicDto.converter(topics);
		} 
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicDto> insertTopic(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
		Topic topic = form.converter(courseRepository);
		topicRepository.save(topic);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topic.getId()).toUri();
			
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TopicDetailsDto> searchTopic(@PathVariable Long id) {
		Optional<Topic> topico = topicRepository.findById(id);
		if(topico.isPresent()) {
			return ResponseEntity.ok(new TopicDetailsDto(topico.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicDto> updateTopic(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form){
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			Topic topic = form.update(id, topicRepository);
			return ResponseEntity.ok(new TopicDto(topic));
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deleteTopic(@PathVariable Long id){
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			topicRepository.deleteById(id);
			return ResponseEntity.ok().build();	
		}
			
		return ResponseEntity.notFound().build();
	}
}

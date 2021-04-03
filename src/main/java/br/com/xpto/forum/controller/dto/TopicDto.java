package br.com.xpto.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.xpto.forum.model.Topic;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopicDto {
	
	private Long id;
	@JsonProperty(value = "titulo")
	private String title;
	@JsonProperty(value = "mensagem")
	private String message;
	@JsonProperty(value = "data de criacao")
	private LocalDateTime createdAt;
	
	public TopicDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.createdAt = topic.getCreatedAt();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getMessage() {
		return message;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public static List<TopicDto> converter(List<Topic> topics) {
		return topics.stream().map(TopicDto::new).collect(Collectors.toList());
	}
}

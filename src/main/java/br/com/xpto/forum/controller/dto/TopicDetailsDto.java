package br.com.xpto.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.xpto.forum.model.enums.TopicStatus;
import br.com.xpto.forum.model.Topic;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopicDetailsDto {

	private Long id;
	@JsonProperty(value = "titulo")
	private String title;
	@JsonProperty(value = "mensagem")
	private String message;
	@JsonProperty(value = "data de criacao")
	private LocalDateTime createdAt;
	@JsonProperty(value = "nome do autor")
	private String nameAuthor;
	@JsonProperty(value = "status")
	private TopicStatus status;
	@JsonProperty(value = "resposta")
	private List<TopicResponseDto> responses;
	
	public TopicDetailsDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.createdAt = topic.getCreatedAt();
		this.nameAuthor = topic.getAuthor().getName();
		this.status = topic.getStatus();
		this.responses = new ArrayList();
		this.responses.addAll(topic.getResponses()
				.stream().map(TopicResponseDto::new).collect(Collectors.toList()));
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

	public String getNameAuthor() {
		return nameAuthor;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public List<TopicResponseDto> getResponses() {
		return responses;
	}
	
	
}

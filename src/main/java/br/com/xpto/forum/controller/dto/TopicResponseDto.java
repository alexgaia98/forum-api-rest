package br.com.xpto.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.xpto.forum.model.TopicResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopicResponseDto {

	private Long id;
	@JsonProperty(value = "mensagem")
	private String message;
	@JsonProperty(value = "data de criacao")
	private LocalDateTime createdAt;
	@JsonProperty(value = "nome do autor")
	private String authorName;
	
	public TopicResponseDto(TopicResponse topicResponse){
		this.id = topicResponse.getId();
		this.message = topicResponse.getMessage();
		this.createdAt = topicResponse.getCreatedAt();
		this.authorName = topicResponse.getAuthor().getName();
		
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getAuthorName() {
		return authorName;
	}
	
}

package br.com.xpto.forum.model;

import br.com.xpto.forum.model.enums.TopicStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Topico")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String title;
	@Column(name = "mensagem")
	private String message;
	@Column(name = "data_criacao")
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private TopicStatus status = TopicStatus.NAO_RESPONDIDO;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private User author;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Course course;
	
	@OneToMany(mappedBy = "topic")
	private List<TopicResponse> responses = new ArrayList<>();
	
	public Topic() {
	}

	public Topic(String title, String message, Course course) {
		super();
		this.title = title;
		this.message = message;
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public void setStatus(TopicStatus status) {
		this.status = status;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<TopicResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<TopicResponse> responses) {
		this.responses = responses;
	}

}

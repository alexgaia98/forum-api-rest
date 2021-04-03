package br.com.xpto.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.xpto.forum.model.Course;
import br.com.xpto.forum.model.Topic;
import br.com.xpto.forum.repository.CourseRepository;

public class TopicForm {
	
	@NotNull
	@NotEmpty
	private String title;
	private String message;
	private String courseName;
	
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Topic converter(CourseRepository courseRepository) {
		Course course = courseRepository.findByName(courseName);
		return new Topic(title, message, course);
		
	}
	
	
}

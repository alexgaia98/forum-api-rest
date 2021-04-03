package br.com.xpto.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xpto.forum.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	Course findByName(String CourseName);

}

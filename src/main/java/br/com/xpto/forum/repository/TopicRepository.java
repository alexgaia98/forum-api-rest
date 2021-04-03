package br.com.xpto.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xpto.forum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{
	
	List<Topic> findByCourse_Name(String CourseName);

}



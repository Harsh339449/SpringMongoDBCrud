package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends MongoRepository<ToDo,String> {

	
	@Query("{'todo':todo}")
	Optional<ToDo> findByTodo(@Param("todo") String todo);
	
	
	
}

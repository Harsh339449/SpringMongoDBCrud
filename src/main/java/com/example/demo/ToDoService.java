package com.example.demo;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepo toDoRepo;

	public ToDo createToDo(ToDo todo) throws ConstraintViolationException, ToDoCollectionException {
		Optional<ToDo> todoOptional = toDoRepo.findByTodo(todo.getTodo());
		if (todoOptional.isPresent()) {
			throw new ToDoCollectionException(ToDoCollectionException.ToDoAlreadyExists(todo.getTodo()));
		}
		todo.setCreatedAt(new Date());
		todo.setUpdatedAt(new Date());

		return toDoRepo.save(todo);

	}

	public ToDo getToDo(String id) throws ToDoCollectionException {
		Optional<ToDo> todoOptional = toDoRepo.findById(id);
		return todoOptional
				.orElseThrow(() -> new ToDoCollectionException(ToDoCollectionException.NotFoundException(id)));

	}

}

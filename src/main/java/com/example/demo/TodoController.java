package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	
	@Autowired
	ToDoRepo toDoRepo;
	@Autowired
	ToDoService toDoService;
	
	
	@GetMapping("/todos")
	public List<ToDo> allTodos(){
		return toDoRepo.findAll();
	}
	@PostMapping("/todos")
	public String addTodo(@Valid @RequestBody ToDo todo){
		try {
			return toDoService.createToDo(todo).toString();
			
		} catch (ToDoCollectionException e) {
			//return ResponseEntity HttpStatus.Conflict;
			return e.getMessage();
		} catch (ConstraintViolationException e) {
			//return ResponseEntity HttpStatus.Conflict;
			return e.getMessage() ;
		}
		
		
	}
	
	
	@GetMapping("/todos/{id}")
	public String getTodo(@PathVariable String id){
	try {
		return toDoService.getToDo(id).toString();
	} catch (ToDoCollectionException e) {
		return e.getMessage();
	}
	}

	@PutMapping("/todos/{id}")
	public ToDo updateTodo(@PathVariable String id, @RequestBody ToDo todo){
		ToDo td= toDoRepo.findById(id).get();
		td.setCompleted(todo.getCompleted());
		td.setDescription(todo.getDescription());
		td.setUpdatedAt(new Date());
		td.setTodo(todo.getTodo());
		return toDoRepo.save(td);
	}
	
	@DeleteMapping("/todos/{id}")
	public String deleteTodo(@PathVariable String id){
		try {
			toDoRepo.deleteById(id);
			return "Deleted successfully by id "+id;
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	
}

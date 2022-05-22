package com.example.demo;

public class ToDoCollectionException extends Exception {

	public ToDoCollectionException(String msg) {
		super(msg);
	}
	
	
	public static String NotFoundException(String id) {
		return "ToDo with id: "+id+" not found";
	}
	
	
	public static String ToDoAlreadyExists(String id) {
		return "ToDo with id: "+id+" already exists";
	}
	
	
}

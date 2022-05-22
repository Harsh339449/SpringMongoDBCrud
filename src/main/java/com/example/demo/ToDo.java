package com.example.demo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "todoDetail")
public class ToDo {
	
	@Id
	private String id;
	
	@NotNull(message = "todo cannot be null")
	private String todo;
	@NotNull(message = "completed cannot be null")
	private Boolean completed;
	@NotNull(message = "description cannot be null")
	private String description;
	private Date createdAt;
	private Date updatedAt;

	public ToDo() {
	}

	public ToDo(String id, String todo, Boolean completed, String description, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.todo = todo;
		this.completed = completed;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", todo=" + todo + ", completed=" + completed + ", description=" + description
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}

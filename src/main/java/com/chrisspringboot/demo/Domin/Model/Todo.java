package com.chrisspringboot.demo.Domin.Model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Todos")
//@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
//we want to include the create date, so I commented the ignoreproperties
public class Todo {

	@Id
	private String id;

	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String title;
	
	private Boolean completed = false;
	
	private Date createdAt = new Date();

	public Todo(String id, String title, Boolean completed, Date createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.completed = completed;
		this.createdAt = createdAt;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed="
				+ completed + ", createdAt=" + createdAt + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}

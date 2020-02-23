package com.polytechnancy.todolist.resources;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "task_name")
	private String taskName;
	
	/*
	it's up to you :
	* Constructor : Task(String taskName)
	* Getters / Setters
	*/
}

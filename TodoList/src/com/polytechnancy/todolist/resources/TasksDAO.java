package com.polytechnancy.todolist.resources;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class TasksDAO {
	
	@PersistenceContext(unitName = "TodoListPU")
	private EntityManager em;
	
	public Task findById(int id) {
		/*
		It's up to you
		*/
		return null;
	}
	
	public List<Task> findAll() {
		return em.createQuery( "SELECT t FROM Task t", Task.class).getResultList();
	}
	
	public void remove(int taskId) {
	    Task task = em.find(Task.class, taskId);    
		if (task != null) {
			em.remove(task);      
		}
	}
	
	public void add(Task task) {
		/*
		It's up to you
		*/
	}
}

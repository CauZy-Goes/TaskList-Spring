package com.cauzy.tasklist.services;

import java.util.List;

import com.cauzy.tasklist.entities.Task;
import com.cauzy.tasklist.repository.TaskRepository;
import com.cauzy.tasklist.services.exceptions.ResourceNotFoundException;

public class TaskService {
	
	private TaskRepository taskRepository;
	
	public Task insert(Task task) {
		return taskRepository.save(task);
	}
	
	public void delete(Long id) {
			findById(id);
			taskRepository.deleteById(id);
	}
	
	public List<Task> findAll(){
		List<Task> taskList = taskRepository.findAll();
		return taskList;
	}
	
	public Task findById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Task update(Task task) {
		Task newTask = taskRepository.getReferenceById(task.getId());
		updateTasks(newTask,task);
		return taskRepository.save(newTask);
	}

	private void updateTasks(Task newTask, Task task) {
		newTask.setDescription(task.getDescription());
		newTask.setDeadLine(task.getDeadLine());
	}
}

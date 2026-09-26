package com.Flyrank.project;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    TaskService(TaskMapper taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> getAllTasks() {
        List<TaskModel> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskMapper :: map)
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id) {
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.map(taskMapper::map).orElse(null);
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        TaskModel taskModel = taskMapper.map(taskDTO);
        taskModel = taskRepository.save(taskModel);
        return taskMapper.map(taskModel);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO updateTask(Long id,TaskDTO taskDTO) {
        Optional<TaskModel> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            TaskModel taskUpdated = taskMapper.map(taskDTO);
            taskRepository.save(taskUpdated);
            TaskModel updatedTask = taskRepository.save(taskUpdated);
            return taskMapper.map(updatedTask);
        }
        return null;
    }
}

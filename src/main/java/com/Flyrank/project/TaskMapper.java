package com.Flyrank.project;

import org.springframework.stereotype.Component;


@Component
public class TaskMapper {

    public TaskModel map(TaskDTO taskDTO){
        TaskModel taskModel = new TaskModel();
        taskModel.setId(taskDTO.getId());
        taskModel.setName(taskDTO.getName());
        taskModel.setDescription(taskDTO.getDescription());
        return taskModel;
    }
    public TaskDTO map(TaskModel taskModel){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(taskModel.getId());
        taskDTO.setName(taskModel.getName());
        taskDTO.setDescription(taskModel.getDescription());
        return taskDTO;
    }
}

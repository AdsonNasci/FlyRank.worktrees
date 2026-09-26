package com.Flyrank.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class TaskController {

    private final TaskService service;

    TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "List all tasks")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
          @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
          @ApiResponse(responseCode = "403", description = "Inter server error"),
          @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    @GetMapping("/listTasks")
    public ResponseEntity<List<TaskDTO>> list(){
        List<TaskDTO> tasks = service.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(summary = "Obtain a task by ID")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully retrieved task"),
          @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @GetMapping("/obtainTask/{id}")
    public ResponseEntity<?> obtainTask(@PathVariable Long id){
        TaskDTO task = service.getTaskById(id);
        if(task != null){
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found"+ id);
        }
    }

    @Operation(summary = "Create a new task")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Task created successfully"),
          @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/addTask")
    public ResponseEntity<String> addTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO newTask = service.createTask(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task created successfully with ID: " + newTask.getId());
    }
    @Operation(summary = "Update an existing task")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Task updated successfully"),
          @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<?> updateTask(@NotNull  @PathVariable Long id, @NotNull @RequestBody TaskDTO taskDTO) {
        if(service.getTaskById(id) != null){
            TaskDTO updatedTask = service.updateTask(id, taskDTO);
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }

    @Operation(summary = "Delete a task by ID")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Task deleted successfully"),
          @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        if(service.getTaskById(id) != null){
            service.deleteTask(id);
            return ResponseEntity.ok("Task deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }
}
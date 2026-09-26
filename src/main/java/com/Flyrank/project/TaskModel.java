package com.Flyrank.project;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "tb_model")
@Entity(name = "task")
@Data
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
}

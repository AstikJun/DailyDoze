package com.example.dailydoze.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "habit_types")
@Getter
@Setter
public class HabitType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_id")
    private Long id;

    @Column(name = "name")
    private String name;

}

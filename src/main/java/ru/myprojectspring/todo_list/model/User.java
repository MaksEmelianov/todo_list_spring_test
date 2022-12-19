package ru.myprojectspring.todo_list.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"Users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
}

package com.example.dailydoze.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)//создаем связь между пользователем и ролью то есть связываем
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "cust_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    Set<Role> roles = new HashSet<>();

    public void setRole(Role roles) {
        this.roles.add(roles);
    }
    public Set<Role> getRole() {
        return roles;
    }
}

package com.example.dailydoze.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Habit> habits = new ArrayList<>();

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
    public void setProfile(Profile profile) {
        this.profile = profile;
        profile.setUser(this);
    }
}

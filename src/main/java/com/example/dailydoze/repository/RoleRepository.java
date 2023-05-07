package com.example.dailydoze.repository;

import com.example.dailydoze.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    //репозиторий который поможет нам использовать методы CRUD

    Role findByRole(String name); //метод поиска роли по названию
}

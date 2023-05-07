package com.example.dailydoze.repository;

import com.example.dailydoze.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email); //метод поиска юзера по почте
}

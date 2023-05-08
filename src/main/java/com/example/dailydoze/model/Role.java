package com.example.dailydoze.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity //аннотация которая говорит спрингу что этот класс нужно создать в бд
@Table(name = "role") //указываем как именно будет называться таблица в бд
@Getter //гетеры
@Setter //сетеры
public class Role { //класс для ролей пользователя
    @Id//помечаем аннотацией чтобы спринг понял что это primary key
    @GeneratedValue(strategy = GenerationType.AUTO)//метод генерации айдишки
    private Long id;

    private String role;

}

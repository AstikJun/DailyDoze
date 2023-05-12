package com.example.dailydoze.model;

import com.example.dailydoze.enums.Languages;
import com.example.dailydoze.enums.Themes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;



    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Languages language;

    @Column(name = "theme")
    @Enumerated(EnumType.STRING)
    private Themes theme;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "profile_image")
    @Transient
    private MultipartFile profileImage;

}

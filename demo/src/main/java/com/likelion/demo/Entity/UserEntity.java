package com.likelion.demo.Entity;

import com.likelion.demo.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Long age;

    @OneToOne(mappedBy = "user")
    private UserDetailEntity userDetail;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .id(id)
                .name(name)
                .email(email)
                .age(age)
                .build();
    }
}
package com.likelion.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_detail")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String phone;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}

package com.likelion.demo.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private String name;
    private String email;
    private Long age;
}

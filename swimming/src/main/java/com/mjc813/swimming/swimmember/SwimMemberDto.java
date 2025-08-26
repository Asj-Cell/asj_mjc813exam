package com.mjc813.swimming.swimmember;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwimMemberDto {

    private Long id;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;
    private Integer maxLock;
}

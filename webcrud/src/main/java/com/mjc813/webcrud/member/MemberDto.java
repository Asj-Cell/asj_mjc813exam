package com.mjc813.webcrud.member;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private String userId;
    private String passwd;
    private String  name;
    private String nickName;


}

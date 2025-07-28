package com.mjc813.webcrud.member;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMemberMybatis {

    void addMember(MemberDto memberDto);

    List<MemberDto> findAll(MemberDto memberDto);
}

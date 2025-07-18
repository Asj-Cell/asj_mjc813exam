package com.mjc813.webcrud.member;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberMybatis {

    void addMember(MemberDto memberDto);

}

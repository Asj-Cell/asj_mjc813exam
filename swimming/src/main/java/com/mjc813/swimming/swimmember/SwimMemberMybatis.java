package com.mjc813.swimming.swimmember;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SwimMemberMybatis {

    void addMember(SwimMemberDto swimMemberDto);
    void update(SwimMemberDto swimMemberDto);
    void deleteById(Long id);
    List<SwimMemberDto> findAll();
    SwimMemberDto findById(Long id);

}

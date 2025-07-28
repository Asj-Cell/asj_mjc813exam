package com.mjc813.webcrud.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberRepository {

    @Autowired
    private IMemberMybatis memberMybatis;

    public void addMember(MemberDto member) {
        memberMybatis.addMember(member);
    }

    public List<MemberDto> findAll(MemberDto memberDto) {
        return memberMybatis.findAll(memberDto);
    }

}

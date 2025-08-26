package com.mjc813.swimming.swimmember;


import com.mjc813.swimming.swimpool.SwimPoolDto;
import com.mjc813.swimming.swimpool.SwimPoolMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwimMemberService {

    @Autowired
    private SwimMemberMybatis mybatisMapper;

    public void addMember(SwimMemberDto memberDto) {
        this.mybatisMapper.addMember(memberDto);
    }

    public List<SwimMemberDto> findAll() {
        List<SwimMemberDto> all = this.mybatisMapper.findAll();
        return all;
    }

    public SwimMemberDto findById(Long id) {
        SwimMemberDto byId = this.mybatisMapper.findById(id);
        return byId;
    }

    public void update(SwimMemberDto dto) {
        this.mybatisMapper.update(dto);
    }

    public void deleteById(Long id) {
        this.mybatisMapper.deleteById(id);
    }
}

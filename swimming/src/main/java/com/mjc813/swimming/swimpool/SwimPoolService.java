package com.mjc813.swimming.swimpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwimPoolService {

    @Autowired
    private SwimPoolMybatis mybatisMapper;

    public void addMember(SwimPoolDto poolDto) {
        this.mybatisMapper.addPoll(poolDto);
    }

    public List<SwimPoolDto> findAll() {
        List<SwimPoolDto> all = this.mybatisMapper.findAll();
        return all;
    }

    public SwimPoolDto findById(Long num) {
        SwimPoolDto byId = this.mybatisMapper.findById(num);
        return byId;
    }

    public void update(SwimPoolDto dto) {
        this.mybatisMapper.update(dto);
    }

    public void deleteById(Long id) {
        this.mybatisMapper.deleteById(id);
    }
}

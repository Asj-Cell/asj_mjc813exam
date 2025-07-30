package com.mjc813.swimming.swimpool;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SwimPoolMybatis {
    public void addPoll(SwimPoolDto obj);
    public List<SwimPoolDto> findAll();
    public SwimPoolDto findById(Long id);
    public void update(SwimPoolDto dto);
    public void deleteById(Long id);
}

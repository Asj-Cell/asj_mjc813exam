package com.example.demo.service;

import com.example.demo.dto.ContactDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IContactMybatisMapper {
    void insert(ContactDto contact);

    List<ContactDto> selectAll(ContactDto contact);

    ContactDto selectById(Long id);

    void update(ContactDto contact);  // 파라미터 수정

    void delete(Long id);
}



package com.example.demo.service;

import com.example.demo.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRepository {

    @Autowired
    private IContactMybatisMapper iContactMapper;

    public void insert(ContactDto contact) {
        iContactMapper.insert(contact);
    }

    public List<ContactDto> selectAll(ContactDto contact) {
        return iContactMapper.selectAll(contact);
    }

    public ContactDto select(Long id) {
        return iContactMapper.selectById(id);
    }

    public void update(ContactDto contact) {
        iContactMapper.update(contact);
    }

    public void delete(Long id) {
        iContactMapper.delete(id);
    }
}
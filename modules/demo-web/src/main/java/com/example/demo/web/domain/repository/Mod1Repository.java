package com.example.demo.web.domain.repository;

import java.util.List;

import com.example.demo.web.domain.entity.Mod1;

public interface Mod1Repository {
    Mod1 findOne(long id);
    List<Mod1> findAll();
    int insert(Mod1 entity);
    int update(Mod1 entity);
    int deleteById(long id);
}

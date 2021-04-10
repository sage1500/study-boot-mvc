package com.example.demo.web.domain.service;

import java.util.List;

import com.example.demo.web.domain.entity.Mod1;

public interface Mod1Service {
    Mod1 findOne(long id);
    List<Mod1> findAll();
    Mod1 save(Mod1 entity);
    int delete(long id);
}

package com.example.demo.web.domain.service;

import java.util.List;

import com.example.demo.web.domain.entity.Mod1;
import com.example.demo.web.domain.repository.Mod1Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class Mod1ServiceImpl implements Mod1Service {
    private final Mod1Repository mod1Repository;

    @Override
    public Mod1 findOne(long id) {
        return mod1Repository.findOne(id);
    }

    @Override
    public List<Mod1> findAll() {
        return mod1Repository.findAll();
    }

    @Override
    public Mod1 save(Mod1 entity) {
        if (entity.getVersion() == 0) {
            mod1Repository.insert(entity);
            entity.setVersion(1);
        } else {
            mod1Repository.update(entity);
        }
        return entity;
    }

    @Override
    public int delete(long id) {
        return mod1Repository.deleteById(id);
    }

}

package com.example.demo.web.domain.service;

import java.util.UUID;

import com.example.demo.web.domain.entity.Todo;
import com.example.demo.web.domain.repository.TodoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

// @Service
// @Transactional
// @RequiredArgsConstructor
public class TodoServiceImpl {
// implements TodoService {
//    private final TodoRepository todoRepository;

    // @Override
    // public Todo save(Todo entity) {
    //     // 追加時はIDを割り振る
    //     if (entity.getTodoId() == null) {
    //         entity.setTodoId(UUID.randomUUID().toString());
    //         entity.setVersion(0);
    //     }

    //     return todoRepository.save(entity);
    // }

    // @Override
    // public Todo findAllByUserId(String userId) {
    //     return todoRepository.findAllByUserId(userId);
    // }

    // @Override
    // public Todo findByUserIdAndTodoId(String userId, String todoId) {
    //     return todoRepository.findByUserIdAndTodoId(userId, todoId);
    // }

    // @Override
    // public boolean deleteByUserIdAndTodoId(String userId, String todoId) {
    //     return todoRepository.deleteByUserIdAndTodoId(userId, todoId);
    // }

}

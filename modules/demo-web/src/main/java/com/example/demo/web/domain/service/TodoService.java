package com.example.demo.web.domain.service;

import com.example.demo.web.domain.entity.Todo;

public interface TodoService {
    Todo save(Todo entity);
    Todo findAllByUserId(String userId);
    Todo findByUserIdAndTodoId(String userId, String todoId);
    boolean deleteByUserIdAndTodoId(String userId, String todoId);
}

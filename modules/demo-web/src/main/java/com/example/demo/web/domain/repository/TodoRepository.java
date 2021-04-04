package com.example.demo.web.domain.repository;

import com.example.demo.web.domain.entity.Todo;

public interface TodoRepository {
    Todo save(Todo todo);
    Todo findAllByUserId(String userId);
    Todo findByUserIdAndTodoId(String userId, String todoId);
    boolean deleteByUserIdAndTodoId(String userId, String todoId);
}

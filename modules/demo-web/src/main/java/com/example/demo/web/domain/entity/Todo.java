package com.example.demo.web.domain.entity;

import lombok.Data;

@Data
public class Todo {
    private String userId;
    private String todoId;
    private String todoTitle;
    private long version;
}

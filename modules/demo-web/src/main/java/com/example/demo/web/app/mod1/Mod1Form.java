package com.example.demo.web.app.mod1;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Mod1Form implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @NotNull(groups = { Create.class, Update.class })
    private String prop1;

    private String prop2;

    private String prop3;

    private long version;

    public interface Create {
    }

    public interface Update {
    }

    public interface Delete {
    }
}

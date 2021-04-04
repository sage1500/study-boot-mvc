package com.example.demo.web.app.mod1;

import java.util.Locale;

import javax.validation.groups.Default;

import com.github.dozermapper.core.Mapper;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
// @RequestMapping("mod1/{id}")
@SessionAttributes("mod1Form")
@RequiredArgsConstructor
@Slf4j
public class Mod1DetailController {
    private final MessageSource messageSource;
    private final Mapper dozerMapper;

    @ModelAttribute("mod1Form")
    public Mod1Form setupTodoForm() {
        return new Mod1Form();
    }

//    @GetMapping("mod1/{id}")
    public String read(Mod1Form todoForm) {
        log.debug("[TODO-UPDATE]index: {}", todoForm);

        // API呼出し
        var todo = "todo"; // todosApi.showTodoById(todoForm.getTodoId())
        dozerMapper.map(todo, todoForm);
        return "todo/todoUpdateInput";
    }

}

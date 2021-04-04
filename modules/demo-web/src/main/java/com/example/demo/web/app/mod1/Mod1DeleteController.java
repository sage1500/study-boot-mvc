package com.example.demo.web.app.mod1;

import com.github.dozermapper.core.Mapper;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("mod1/delete")
@SessionAttributes("mod1Form")
@RequiredArgsConstructor
@Slf4j
public class Mod1DeleteController {
    private final MessageSource messageSource;
    private final Mapper dozerMapper;

    @ModelAttribute("mod1Form")
    public Mod1Form setupTodoForm() {
        return new Mod1Form();
    }

//    @PostMapping("/")
    public String index(Mod1Form todoForm) {
        log.debug("[TODO-DELETE]index: {}", todoForm);
        // TODO var todo = todosApi.showTodoById(todoForm.getTodoId())
        // TODO dozerMapper.map(todo, todoForm);
        return "todo/todoDeleteConfirm";
    }

//    @PostMapping("execute")
    public String execute(Mod1Form todoForm) {
        log.debug("[TODO-DELETE]execute: {}", todoForm);

        // TODO var result = todosApi.deleteTodo(todoForm.getTodoId())
        // String msgKey =  (result) ? "message.todo.delete.success" : "message.todo.delete.success-deleted";
        // String msg = messageSource.getMessage(msgKey, null, Locale.ROOT);
        return "redirect:complete";
    }

    // TODO PRG
 //   @GetMapping("complete")
    public String complete(SessionStatus sessionStatus, @RequestParam("message") String message, Model model) {
        log.debug("[TODO-DELETE]complete: message={}", message);
        sessionStatus.setComplete();
        model.addAttribute("message", message);
        return "todo/todoDeleteComplete";
    }

//    @GetMapping("cancel")
    public String cancel(SessionStatus sessionStatus) {
        log.debug("[TODO-DELETE]cancel");
        sessionStatus.setComplete();
        return "redirect:/todo/";
    }

}

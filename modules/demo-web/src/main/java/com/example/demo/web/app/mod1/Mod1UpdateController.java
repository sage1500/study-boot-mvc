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
//@RequestMapping("mod1/update")
@SessionAttributes("mod1Form")
@RequiredArgsConstructor
@Slf4j
public class Mod1UpdateController {
    private final MessageSource messageSource;
    private final Mapper dozerMapper;

    @ModelAttribute("mod1Form")
    public Mod1Form setupTodoForm() {
        return new Mod1Form();
    }

//    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
    public String index(Mod1Form todoForm) {
        log.debug("[TODO-UPDATE]index: {}", todoForm);

        // API呼出し
        var todo = "todo"; // todosApi.showTodoById(todoForm.getTodoId())
        dozerMapper.map(todo, todoForm);
        return "todo/todoUpdateInput";
    }

//    @PostMapping("input")
    public String input(Mod1Form todoForm) {
        log.debug("[TODO-UPDATE]input: {}", todoForm);
        return "todo/todoUpdateInput";
    }

//    @PostMapping("confirm")
    public String confirm(@Validated({ Default.class, Mod1Form.Update.class }) Mod1Form todoForm,
            BindingResult bindingResult) {
        log.debug("[TODO-UPDATE]confirm: {}", todoForm);

        if (bindingResult.hasErrors()) {
            return input(todoForm);
        }

        return "todo/todoUpdateConfirm";
    }

//    @PostMapping("execute")
    public String execute(Mod1Form todoForm) {
        log.debug("[TODO-UPDATE]execute: {}", todoForm);

        // TODO Form -> Entity
        // TodoResource todo = dozerMapper.map(todoForm, TodoResource.class);

        try {
            // TODO Update
            // TODO Entity -> Form 
            // dozerMapper.map(result, todoForm);

            // TODO PRGでやる
            String msg = messageSource.getMessage("message.todo.update.success", null, Locale.ROOT);
            return "";
        } catch (/* TODO 更新が競合した場合 */ Exception e) {
                log.debug("[TODO-UPDATE]update failed: {}", e.getMessage());
            // TODO PRGでやる
            String msg = messageSource.getMessage("message.todo.update.failed-conflict", null, Locale.ROOT);
            return "";
        }
    }

    // TODO PRGでやる
//    @GetMapping("complete")
    public String complete(SessionStatus sessionStatus, @RequestParam("message") String message, Model model) {
        log.debug("[TODO-UPDATE]complete: message={}", message);
        sessionStatus.setComplete();
        model.addAttribute("message", message);
        return "todo/todoUpdateComplete";
    }

//    @GetMapping("cancel")
    public String cancel(SessionStatus sessionStatus) {
        log.debug("[TODO-UPDATE]cancel");
        sessionStatus.setComplete();
        return "redirect:/todo/";
    }

}

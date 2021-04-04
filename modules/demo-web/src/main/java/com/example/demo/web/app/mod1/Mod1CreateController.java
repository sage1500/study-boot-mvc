package com.example.demo.web.app.mod1;

import javax.validation.groups.Default;

import com.github.dozermapper.core.Mapper;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("mod1/create")
@SessionAttributes("mod1Form")
@RequiredArgsConstructor
@Slf4j
public class Mod1CreateController {
    private final MessageSource messageSource;
    private final Mapper dozerMapper;

    @ModelAttribute("mod1Form")
    //@ModelAttribute
    public Mod1Form setUpMod1Form() {
        return new Mod1Form();
    }

    // @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    // public String index(SessionStatus sessionStatus) {
    //     log.debug("[TODO-CREATE]index");

    //     // URL直接入力されると、セッションが残ったままの可能性があるため、
    //     // セッションから削除して、入力画面にリダイレクト
    //     sessionStatus.setComplete();
    //     return "redirect:input";
    // }

    @GetMapping(params = "form")
    public String createForm(Mod1Form mod1Form) {
        log.debug("[MOD1-CREATE]createForm: {}", mod1Form);
        return "mod1/mod1CreateForm";
    }

    @PostMapping(params = "redo")
    public String createRedo(Mod1Form mod1Form) {
        log.debug("[MOD1-CREATE]createRedo: {}", mod1Form);
        return "mod1/mod1CreateForm";
    }

    @PostMapping(params = "confirm")
    public String createConfirm(@Validated({ Default.class, Mod1Form.Create.class }) Mod1Form mod1Form,
            BindingResult bindingResult) {
        log.debug("[MOD1-CREATE]createConfirm: {}", mod1Form);

        if (bindingResult.hasErrors()) {
            return createRedo(mod1Form);
        }

        return "mod1/mod1CreateConfirm";
    }

    @PostMapping
    public String create(@Validated({ Default.class, Mod1Form.Create.class }) Mod1Form mod1Form, BindingResult bindingResult) {
        log.debug("[MOD1-CREATE]create: {}", mod1Form);

        if (bindingResult.hasErrors()) {
            return createRedo(mod1Form);
        }

        // TODo form -> entity
        // Todo todo = dozerMapper.map(todoForm, Todo.class);

        // TODO var result = todosApi.createTodo(todo)
        // TODO dozerMapper.map(result, todoForm);
        // TODO PRGパターンに
        //String msg = messageSource.getMessage("message.todo.create.success", null, Locale.ROOT);

        return "redirect:/mod1/create?complete"; 
    }

    @GetMapping(params = "complete")
    public String createComplete(SessionStatus sessionStatus) {
        log.debug("[MOD1-CREATE]createComplete");
        sessionStatus.setComplete();
        return "mod1/mod1CreateComplete";
    }

    @PostMapping(params = "cancel")
    public String createCancel(SessionStatus sessionStatus) {
        log.debug("[MOD1-CREATE]createCancel");
        sessionStatus.setComplete();
        return "redirect:/mod1/list";
    }
}

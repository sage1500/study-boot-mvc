package com.example.demo.web.app.mod1;

import com.example.demo.web.domain.service.Mod1Service;
import com.github.dozermapper.core.Mapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("mod1")
@RequiredArgsConstructor
@Slf4j
public class Mod1DetailController {
    private final Mod1Service mod1Service;
    private final Mapper dozerMapper;

    @ModelAttribute("mod1Form")
    public Mod1Form setupTodoForm() {
        return new Mod1Form();
    }

    @GetMapping("{id}")
    public String detail(@PathVariable("id") long id, Mod1Form mod1Form) {
        log.debug("[MOD1-DETAIL]detail: {}", id);

        // 業務ロジック呼び出し
        var mod1 = mod1Service.findOne(id);

        // 画面に反映
        dozerMapper.map(mod1, mod1Form);
        return "mod1/mod1Detail";
    }

}

package com.example.demo.web.app.mod1;

import java.util.Locale;

import com.example.demo.web.domain.service.Mod1Service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("mod1")
@RequiredArgsConstructor
@Slf4j
public class Mod1DeleteController {
    private final Mod1Service mod1Service;
    private final MessageSource messageSource;

    @PostMapping(path = "{id}/delete")
    public String execute(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        log.debug("[MOD1-DELETE]execute: {}", id);

        // 業務ロジック呼び出し
        mod1Service.delete(id);

        // 画面に反映
        var msg = messageSource.getMessage("i.w1.m1.0201", null, Locale.ROOT);
        redirectAttributes.addFlashAttribute("message", msg);
        return "redirect:/mod1/{id}/delete?complete";
    }

    @GetMapping(path = "{id}/delete", params = "complete")
    public String complete() {
        log.debug("[MOD1-DELETE]complete");
        return "mod1/mod1DeleteComplete";
    }

}

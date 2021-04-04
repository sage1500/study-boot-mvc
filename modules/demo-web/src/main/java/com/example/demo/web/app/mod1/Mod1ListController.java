package com.example.demo.web.app.mod1;

import java.util.ArrayList;

import com.example.demo.web.domain.entity.Mod1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("mod1")
@RequiredArgsConstructor
@Slf4j
public class Mod1ListController {

    @GetMapping("mod1/list")
    public String index(Model model) {
        log.debug("[TODO]index");

        // Mod1一覧取得API呼出し
        var list = new ArrayList<Mod1>(); // todosApi.listTodos()
        var mod1 = new Mod1();
        mod1.setId("1");
        mod1.setProp1("11");
        mod1.setProp2("12");
        mod1.setProp3("13");
        list.add(mod1);

        mod1.setId("2");
        mod1.setProp1("21");
        mod1.setProp2("22");
        mod1.setProp3("23");
        list.add(mod1);

        model.addAttribute("list", list);
        return "mod1/mod1List";
    }

}

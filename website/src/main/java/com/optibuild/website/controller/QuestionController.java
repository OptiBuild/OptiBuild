package com.optibuild.website.controller;

import com.optibuild.website.Service.ComponentService;
import com.optibuild.website.model.Answer;
import com.optibuild.website.model.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class QuestionController {
    private final ComponentService componentService;

    // 注入ComponentService
    public QuestionController(ComponentService componentService) {
        this.componentService = componentService;
    }

    // users submit answers
    @PostMapping("/questions")
    public ResponseEntity<List<Component>> submitAnswers(@RequestBody List<ArrayList<Answer>> answers) {
        // 调用服务类处理答案，并获取匹配的components
        ArrayList<ArrayList<String>> parseResult = componentService.parseAnswer(answers);
        List<Component> components = componentService.getMatchingComponents(parseResult);
        // 返回匹配的components
        return ResponseEntity.ok(components);
    }
}

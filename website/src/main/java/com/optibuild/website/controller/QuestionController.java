package com.optibuild.website.controller;

import com.optibuild.website.Service.ComponentService;
import com.optibuild.website.Service.ProcessAnswerService;
import com.optibuild.website.model.Answer;
import com.optibuild.website.model.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResponseErrorHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("localhost:8888")
public class QuestionController {
    private final ComponentService componentService;
    private final ProcessAnswerService processAnswerService;

    // 注入ComponentService
    public QuestionController(ComponentService componentService, ProcessAnswerService processAnswerService) {
        this.componentService = componentService;
        this.processAnswerService = processAnswerService;
    }

    // users submit answers
    @PostMapping("/questions")
    public ResponseEntity<Map<String, String>> submitAnswers(@RequestBody Object answer) {
        // deal with different answer types
        List<Answer> answers = processAnswerService.processAnswers(answer);
        // parse different answers to the corresponding component specifications
        List<List<String>> parseResult = processAnswerService.parseAnswer(answers);
        // process the answer and obtain the component list
        Map<String, String> components = componentService.getMatchingComponents(parseResult);

        return ResponseEntity.ok(components);
    }
}

package com.optibuild.website.controller;

import com.optibuild.website.Service.ComponentService;
import com.optibuild.website.Service.ProcessAnswerService;
import com.optibuild.website.model.Answer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    private final ComponentService componentService;
    private final ProcessAnswerService processAnswerService;

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

    // users submit answers
    @PostMapping("/alternatives")
    public ResponseEntity<Map<String, String>> Alternatives(@RequestBody Object answer) {
        // deal with different answer types
        List<Answer> answers = processAnswerService.processAnswers(answer);
        // parse different answers to the corresponding component specifications
        List<List<String>> parseResult = processAnswerService.parseAnswer(answers);
        // process the answer and obtain the component list
        Map<String, String> components = componentService.getMatchingComponents(parseResult);
        return ResponseEntity.ok(components);
    }
}

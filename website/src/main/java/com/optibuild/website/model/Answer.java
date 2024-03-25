package com.optibuild.website.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    @Getter
    @Setter
    private String questionId; // 问题的唯一标识符
    private List<ArrayList<String>> choices; // 用户的答案选择

    public Answer(String questionId, List<ArrayList<String>> choices) {
        this.questionId = questionId;
        this.choices = choices;
    }




}

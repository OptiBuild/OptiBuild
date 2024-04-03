package com.optibuild.website.model;

import lombok.Getter;
import lombok.Setter;


import java.util.List;


public class Answer {

    @Getter
    @Setter
    private int questionId; // 问题的唯一标识符
    private List<String> choices; // 用户的答案选择

    public Answer(int questionId, List<String> choices) {
        this.questionId = questionId;
        this.choices = choices;
    }

    public Answer() {
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}

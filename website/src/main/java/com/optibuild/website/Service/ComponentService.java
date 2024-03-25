package com.optibuild.website.Service;

import com.optibuild.website.model.Answer;
import com.optibuild.website.model.Component;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Component
public class ComponentService {


    // TODO: get the information of each components from database
    //  可能需要注入repository来与数据库交互
    // private final ComponentRepository componentRepository;


    //TODO: Parse user's answer
    public ArrayList<ArrayList<String>> parseAnswer(List<ArrayList<Answer>> answers) {
        // logic for transferring answers to specifications of each component

        return new ArrayList<ArrayList<String>>();// return the specifications of each component
    }

    // TODO: Get specific components according to the corresponding specifications
    public List<Component> getMatchingComponents(ArrayList<ArrayList<String>> specifications) {
        List<Component> components = null;
        
        return components;
    }

    // 其他相关的方法省略
}

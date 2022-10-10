package models;

import helpers.Grade;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String code;
    private String name;
    private List<Subject> subjectList;

    public Teacher(String name) {
        this.code = "TE" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void addSubject(Subject sub) {
        if (this.subjectList == null) {
            this.subjectList = new ArrayList<>();
        }

        this.subjectList.add(sub);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Teacher: \n" +
                "code: " + code +
                ", name: " + name +
                ", subjectList: " + subjectList +'\n';
    }
}

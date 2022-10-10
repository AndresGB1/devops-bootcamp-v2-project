package models;

import helpers.Grade;
import helpers.Score;

public class Student {
    private String code;
    private String name;
    private int age;
    private Grade grade;
    private Score score;

    public Student(String name, int age, Grade grade) {
        this.code = "ST" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getScore() {
        return getScore();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student >> \n" +
                "code: " + code +
                ", name: " + name +
                ", age: " + age +
                ", grade: " + grade +
                ", score: " + score+'\n';
    }
}

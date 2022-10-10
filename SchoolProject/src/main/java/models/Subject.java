package models;

import helpers.Grade;

public class Subject {
    private String name;
    private String teacher;
    private Grade grade;

    public Subject(String name, String teacher, Grade grade) {
        this.name = name;
        this.teacher = teacher;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Subject " +
                "name: '" + name + '\'' +
                ", teacher: '" + teacher + '\'' +
                ", grade: " + grade +
                '}';
    }
}

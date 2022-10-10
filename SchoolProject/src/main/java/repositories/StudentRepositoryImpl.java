package repositories;

import helpers.Grade;
import models.Student;

import java.util.*;

public class StudentRepositoryImpl implements IStudentRepository {

    private Map<String, Student> studentCollection;

    public StudentRepositoryImpl() {
        this.studentCollection = new HashMap<>();
    }


    @Override
    public <S extends Student> S save(S entity) {
         studentCollection.put(entity.getCode(), entity);
         return entity;
    }

    @Override
    public Optional<Student> findByCode(String s) {
        return Optional.ofNullable(studentCollection.get(s));
    }

    @Override
    public boolean existsByCode(String s) {
        return studentCollection.containsKey(s);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentCollection.values());
    }

    @Override
    public <S extends Student> S delete(S entity) {
        studentCollection.entrySet().removeIf(e -> e.getKey().equals(entity.getCode()));
        return entity;
    }

    @Override
    public List<Student> findByGrade(String grade) {
        var students = new ArrayList<Student>();
        try {
            var grade2 = Grade.valueOf(grade);
            for (var student : studentCollection.values()) {
                if (student.getGrade().equals(grade2)) {
                    students.add(student);
                }
            }
        }
        catch (Exception e) {
         return null;
        }
        return students;
    }
}

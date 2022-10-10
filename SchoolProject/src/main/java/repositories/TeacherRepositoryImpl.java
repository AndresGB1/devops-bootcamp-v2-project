package repositories;

import models.Teacher;

import java.util.*;

public class TeacherRepositoryImpl implements ITeacherRepository {
    private Map<String, Teacher> teacherCollection;

    public TeacherRepositoryImpl() {
        this.teacherCollection = new HashMap<>();
    }


    @Override
    public <S extends Teacher> S save(S entity) {
        teacherCollection.put(entity.getCode(), entity);
        return entity;
    }

    @Override
    public Optional<Teacher> findByCode(String s) {
        return Optional.ofNullable(teacherCollection.get(s));
    }

    @Override
    public boolean existsByCode(String s) {
        return teacherCollection.containsKey(s);
    }

    @Override
    public List<Teacher> findAll() {
        return new ArrayList<>(teacherCollection.values());
    }

    @Override
    public <S extends Teacher> S delete(S entity) {
        teacherCollection.entrySet().removeIf(e -> e.getKey().equals(entity.getCode()));
        return entity;
    }
}

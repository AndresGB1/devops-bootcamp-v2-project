package repositories;

import models.Subject;

import java.util.*;

public class SubjectRepositoryImpl implements ISubjectRepository {

    private Map<String, Subject> subjects;

    public SubjectRepositoryImpl() {
        subjects = new HashMap<>();
    }


    @Override
    public <S extends Subject> S save(S entity) {
        subjects.put(entity.getName(), entity);
        return entity;
    }

    @Override
    public Optional<Subject> findByCode(String s) {
        return Optional.ofNullable(subjects.get(s));
    }

    @Override
    public boolean existsByCode(String s) {
        return subjects.containsKey(s);
    }

    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(subjects.values());
    }

    @Override
    public <S extends Subject> S delete(S entity) {
        subjects.entrySet().removeIf(e -> e.getKey().equals(entity.getName()));
        return entity;
    }
}

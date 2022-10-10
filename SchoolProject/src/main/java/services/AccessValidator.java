package services;

import models.Student;
import models.Teacher;
import repositories.IBaseRepository;

public class AccessValidator {
    private IBaseRepository baseRepository;

    public AccessValidator(IBaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public Student verifyStudentAccess(String code) {
        return (Student) this.baseRepository.findByCode(code).orElse(null);
    }

    public Teacher verifyTeacherAccess(String code) {
        return (Teacher) this.baseRepository.findByCode(code).orElse(null);
    }
}

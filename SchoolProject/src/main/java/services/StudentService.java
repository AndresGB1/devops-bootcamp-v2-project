package services;


import lombok.AllArgsConstructor;
import models.Student;
import org.springframework.stereotype.Service;
import repositories.IStudentRepository;
import repositories.StudentRepositoryImpl;

import java.util.List;
@AllArgsConstructor
@Service
public class StudentService {
    private final IStudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return  studentRepository.save(student);
    }

    public Student findStudentByCode(String code) {
        return studentRepository.findByCode(code).orElse(null);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public void deleteStudentByCode(String code) {
        studentRepository.delete(findStudentByCode(code));
    }
    public void saveStudentToRepository(List<Student> students) {
        for (Student student : students) {
            studentRepository.save(student);
        }
    }
}

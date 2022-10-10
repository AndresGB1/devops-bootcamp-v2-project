package repositories;

import helpers.Grade;
import models.Student;

import java.util.List;

public interface IStudentRepository extends IBaseRepository<Student, String> {


    List<Student> findByGrade(String grade);



}

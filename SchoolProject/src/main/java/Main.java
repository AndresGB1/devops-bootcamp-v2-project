import helpers.Grade;
import models.School;
import models.Student;
import models.Subject;
import models.Teacher;
import repositories.StudentRepositoryImpl;
import repositories.SubjectRepositoryImpl;
import repositories.TeacherRepositoryImpl;
import services.AccessValidator;
import services.ReadDataService;
import services.WriteDataService;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String args[]) {

        var studentJsonPath = "src/main/resources/students.json";
        var teacherJsonPath = "src/main/resources/teachers.json";

        var view = new View();

        //Create repositories
        var studentRepository = new StudentRepositoryImpl();
        var teacherRepository = new TeacherRepositoryImpl();
        var subjectRepository = new SubjectRepositoryImpl();


        //Read data from json files
        var readDataService = new ReadDataService();
        var students = readDataService.readDataFromJson(studentJsonPath, Student[].class);
        var teachers = readDataService.readDataFromJson(teacherJsonPath, Teacher[].class);


        //Add data to repositories
        WriteDataService writeDataService = new WriteDataService();
        writeDataService.writeData(students,studentRepository);
        writeDataService.writeData(teachers,teacherRepository);
        for (Teacher teacher : teachers) {
            teacher.getSubjectList().forEach(subjectRepository::save);
        }
        //See data in repositories
        //view.showMessage(studentRepository.findAll().toString());
        //view.showMessage(teacherRepository.findAll().toString());
        //view.showMessage(subjectRepository.findAll().toString());

        //Create school
        var school = new School("American School");

        view.showMenu(school.getName());
        String option = view.getString();

        boolean access = false;

        while (!access) {
            view.showMessage("Please enter your code");


            String code = view.getString();

            switch (option) {
                case "1":
                    var accessValidator = new AccessValidator(teacherRepository);
                    var teacher = accessValidator.verifyTeacherAccess(code);
                    if (teacher != null) {
                        access = true;
                        view.showMessage("Welcome " + teacher.getName());
                        //List the students of "ELEMENTARY_SCHOOL" grade
                        //Enter a grade for a student
                        view.showMessage("1. List the students of a grade");
                        view.showMessage("2. Enter a grade for a student");

                        String option2 = view.getString();

                        switch (option2) {
                            case "1":
                                view.showMessage("Enter the grade");
                                String grade = view.getString();
                                view.showMessage(studentRepository.findByGrade(grade).toString());
                                break;
                            case "2":
                                view.showMessage("Enter the student code");
                                String studentCode = view.getString();
                                view.showMessage("Enter the grade");
                                String grade2 = view.getString();
                                var x =  studentRepository.findByCode(studentCode).get();
                                x.setGrade(Grade.valueOf(grade2));
                                studentRepository.save(x);
                                break;
                        }

                        break;
                    }
                case "2":
                    accessValidator = new AccessValidator(teacherRepository);
                    var student = accessValidator.verifyStudentAccess(code);
                    List<Subject> subjects = new ArrayList<>();
                    if (student != null) {
                        access = true;
                        view.showMessage("Welcome " + student.getName());
                        for (Subject subject : subjectRepository.findAll()) {
                            if(subject.getGrade() == student.getGrade()){
                                subjects.add(subject);
                            }
                        }
                        view.showMessage("Your subjects are: " + subjects);
                        break;
                    }
            }
        }
    }
}

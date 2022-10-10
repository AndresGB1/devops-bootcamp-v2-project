import helpers.Grade;
import models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.IStudentRepository;
import repositories.StudentRepositoryImpl;
import services.StudentService;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class studentServiceTest {

    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        this.studentService = new StudentService(studentRepository);

    }
    @Mock
    private IStudentRepository studentRepository;


    @Test
    public void testReadData() {

        Student student = new Student("Juanito",20, Grade.valueOf("MIDDLE_SCHOOL"));

        when(studentRepository.save(student)).thenReturn(student);

        var result = studentService.saveStudent(student);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Juanito");
    }

}

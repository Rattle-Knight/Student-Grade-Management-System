package uk.ac.rhul.cs2800.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;




/**
 * this is the Test class For the Grade Controller.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class GradeControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private GradeRepository gradeRepository;
  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private ModuleRepository moduleRepository;

  Student student;
  Module module;
  
  /**
   * this function instantiates a new student and module before every test.
   */
  @BeforeEach
  public void beforeEach() {

    // sets student
    this.student = new Student();
    student.setId(1);
    student.setFirstName("alice");
    student.setLastName("brandy");
    student.setUsername("BossBrandy");
    student.setEmail("alicebrandy@gmail.com");

    student = studentRepository.save(student);

    // sets module
    this.module = new Module();

    module.setCode("CS2800");
    module.setName("Software Enginnering");
    module.setMnc(true);

    module = moduleRepository.save(module);

  }
  

  
}

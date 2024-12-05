package uk.ac.rhul.cs2800.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.ac.rhul.cs2800.model.Grade;
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
    student.setId(0);
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
  
  @Test
  public void addGradeTest() throws JsonProcessingException, Exception {
    Map<String, String> params = new HashMap<String, String>();
    params.put("student_id", "0");;
    params.put("module_code", "CS2800");
    params.put("score", "90");
    
    MvcResult action = mockMvc
        .perform(MockMvcRequestBuilders.post("/grades/addGrade")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(params)).accept(MediaType.APPLICATION_JSON))
        .andReturn();
    assertEquals(HttpStatus.OK.value(), action.getResponse().getStatus());

    Grade grade = objectMapper.readValue(action.getResponse().getContentAsString(), Grade.class);
    
    //tests ids of student
    assertEquals(grade.getStudent().getId(), student.getId());
    
    //tests ids of module
    assertEquals(grade.getModule().getCode(), module.getCode());
    
    // tests score
    assertEquals(grade.getScore(), 90);


  }
  
}

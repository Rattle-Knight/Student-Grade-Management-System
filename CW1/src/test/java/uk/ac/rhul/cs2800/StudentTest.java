package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;

/**
 * Unit test for Student Class.
 */
public class StudentTest {

  @Test
  public void getandsetStudentFields() {
    // test 1
    Student student = new Student();

    student.setId(1);
    final long id = student.getId();

    student.setFirstName("alice");
    final String name = student.getFirstName();

    student.setLastName("brandy");
    final String lastname = student.getLastName();

    student.setUsername("BossBrandy");
    final String username = student.getUsername();

    student.setEmail("alicebrandy@gmail.com");
    final String email = student.getEmail();

    assertEquals(1, id);
    assertEquals("alice", name);
    assertEquals("brandy", lastname);
    assertEquals("BossBrandy", username);
    assertEquals("alicebrandy@gmail.com", email);
  }

  @Test
  public void moduleTest() {
    // test 2
    Module module = new Module();

    module.setCode("CS2800");
    final String code = module.getCode();

    module.setName("Software Enginnering");
    final String name = module.getName();

    module.setMnc(true);
    final boolean mnc = module.getMnc();

    assertEquals("CS2800", code);
    assertEquals("Software Enginnering", name);
    assertEquals(true, mnc);
  }

  @Test
  public void gradeTest() {
    // test 3
    Grade grade = new Grade();

    grade.setScore(90);
    final Integer score = grade.getScore();

    assertEquals(90, score);
  }

  @Test
  public void registerModule() {
    // test 4
    Student student = new Student();

    student.setId(1);
    student.setFirstName("alice");
    student.setLastName("brandy");
    student.setUsername("BossBrandy");
    student.setEmail("alicebrandy@gmail.com");

    Module module = new Module();
    module.setCode("CS2800");
    module.setName("Software Enginnering");
    module.setMnc(true);

    student.registerModule(module);

    final List<Registration> registrations = student.getRegistrations();
    assertEquals(module, registrations.get(0));
  }

}

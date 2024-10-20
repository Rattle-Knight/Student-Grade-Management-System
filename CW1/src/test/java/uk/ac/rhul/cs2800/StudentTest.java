package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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

}

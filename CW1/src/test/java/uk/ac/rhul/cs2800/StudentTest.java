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
}

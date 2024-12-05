package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Registration;
import uk.ac.rhul.cs2800.model.Student;


/**
 * this is the main unit tester for all methods within the student class.
 */
public class StudentTest {

  Student student;

  /**
   * this function instantiates a new student before every test.
   */
  @BeforeEach
  public void beforeEach() {
    this.student = new Student();
    student.setId(1);
    student.setFirstName("alice");
    student.setLastName("brandy");
    student.setUsername("BossBrandy");
    student.setEmail("alicebrandy@gmail.com");
  }

  @Test
  public void getandsetStudentFields() {
    // test 1
    final long id = student.getId();
    final String name = student.getFirstName();
    final String lastname = student.getLastName();;
    final String username = student.getUsername();
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
  public void registerModuleTest() {
    // test 4

    Module module = new Module();
    module.setCode("CS2800");
    module.setName("Software Enginnering");
    module.setMnc(true);

    student.registerModule(module);

    final List<Registration> registrations = student.getRegistrations();
    
    final String moduleReferencetest = registrations.get(0).getModuleReference();

    

    // tests modules attributes against module attributes in the registration
    assertEquals("CS2800", moduleReferencetest);
  }

  @Test
  public void addGradeTest() throws NoRegistrationException, NoGradeAvailableException {
    // test 5

    Module module = new Module();
    module.setCode("CS2800");
    module.setName("Software Enginnering");
    module.setMnc(true);

    student.registerModule(module);
    
    //grade has a reference to the code of the module that it is registered for
    Grade grade = new Grade();

    grade.setScore(90);
    grade.setModuleReference("CS2800");
    
    //adds the grade
    student.addGrade(grade);
    
    //gets the newly added grade
    Grade testgrade = student.getGrade(module);
    
    assertEquals(grade.getModuleReference(), testgrade.getModuleReference());
    assertEquals(grade.getScore(), testgrade.getScore());

  }

  @Test
  public void noModuleRegisteredTest() throws NoRegistrationException {
    // test 6

    Grade grade = new Grade();
    grade.setScore(90);
    grade.setModuleReference("CS999999");

    Throwable exception =
        assertThrows(NoRegistrationException.class, () -> student.addGrade(grade));
    assertEquals("No Registered Module with Code CS999999", exception.getMessage());

  }

  @Test
  public void addMultipleModulesTest() throws NoRegistrationException, NoGradeAvailableException {
    // test 7

    Module module = new Module();
    module.setCode("CS2800");
    module.setName("Software Enginnering");
    module.setMnc(true);

    student.registerModule(module);

    Module module2 = new Module();
    module2.setCode("CS2850");
    module2.setName("Operating Systems");
    module2.setMnc(true);

    student.registerModule(module2);

    // grade is registered for 2nd module
    Grade grade = new Grade();

    grade.setScore(10);
    grade.setModuleReference("CS2850");


    // adds the grade
    student.addGrade(grade);

    // gets the newly added grade
    Grade testgrade = student.getGrade(module2);

    assertEquals(grade.getModuleReference(), testgrade.getModuleReference());
    assertEquals(grade.getScore(), testgrade.getScore());

  }

  @Test
  public void noGradeAvailableTest() throws NoRegistrationException, NoGradeAvailableException {
    // test 8

    Module module = new Module();
    module.setCode("CS2850");
    module.setName("Operating Systems");
    module.setMnc(true);


    Throwable exception =
        assertThrows(NoGradeAvailableException.class, () -> student.getGrade(module));
    assertEquals("No Grade Available with associated Module CS2850", exception.getMessage());

  }

  @Test
  public void addMultipleGradesTest() throws NoRegistrationException, NoGradeAvailableException {
    // test 9

    Module module = new Module();
    module.setCode("CS2800");
    module.setName("Software Enginnering");
    module.setMnc(true);

    student.registerModule(module);

    Module module2 = new Module();
    module2.setCode("CS2850");
    module2.setName("Operating Systems");
    module2.setMnc(true);

    student.registerModule(module2);

    // grade is registered for 2nd module
    Grade grade = new Grade();

    grade.setScore(10);
    grade.setModuleReference("CS2800");

    Grade grade2 = new Grade();

    grade2.setScore(100);
    grade2.setModuleReference("CS2850");


    // adds the grades
    student.addGrade(grade);
    student.addGrade(grade2);

    // gets the newly added grade
    Grade testgrade = student.getGrade(module2);

    assertEquals(grade2.getModuleReference(), testgrade.getModuleReference());
    assertEquals(grade2.getScore(), testgrade.getScore());

  }

  @Test
  public void computeAverageGradeTest() throws NoRegistrationException, NoGradeAvailableException {
    // test 10

    Module module = new Module();
    module.setCode("CS2800");
    module.setName("Software Enginnering");
    module.setMnc(true);

    student.registerModule(module);

    Module module2 = new Module();
    module2.setCode("CS2850");
    module2.setName("Operating Systems");
    module2.setMnc(true);

    student.registerModule(module2);

    Module module3 = new Module();
    module3.setCode("CS2855");
    module3.setName("Databases");
    module3.setMnc(true);

    student.registerModule(module3);

    // grades added for all modules
    Grade grade = new Grade();

    grade.setScore(95);
    grade.setModuleReference("CS2800");

    Grade grade2 = new Grade();

    grade2.setScore(100);
    grade2.setModuleReference("CS2850");

    Grade grade3 = new Grade();

    grade3.setScore(75);
    grade3.setModuleReference("CS2855");


    // adds the grades
    student.addGrade(grade);
    student.addGrade(grade2);
    student.addGrade(grade3);

    float average = student.computeAverage();

    assertEquals(90, average);

  }

  @Test
  public void computeAverageGradeWithNoGradesTest()
      throws NoRegistrationException, NoGradeAvailableException {
    // test 11

    float average = student.computeAverage();

    assertEquals(0, average);

  }
}

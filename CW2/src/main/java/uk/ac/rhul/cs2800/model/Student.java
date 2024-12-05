package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;


/**
 * this is a class for representing a Student in the grade management program.
 */
@Entity
public class Student {

  @Id
  private long id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;

  @OneToMany(mappedBy = "student")
  private List<Grade> grades = new ArrayList<>();

  @OneToMany(mappedBy = "student")
  private List<Registration> registrations = new ArrayList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * lists current registrations.
   *
   * @return returns a list of registrations.
   */
  public List<Registration> listRegistrations() {
    return registrations;
  }

  /**
   * this method registers a module into a registration object it then adds that object to this
   * students, registrations.
   *
   * @param moduleToRegister the module that is to be registered.
   * 
   */

  public void registerModule(Module moduleToRegister) {
    Registration registration = new Registration();
    registration.setModule(moduleToRegister);

    this.registrations.add(registration);
  }

  /**
   * this method adds the grade to the students grades array, if there is a registered module
   * referenced to that grade.
   *
   * @param gradeToAdd the grade to be added to the students grades array.
   */
  public void addGrade(Grade gradeToAdd) throws NoRegistrationException {

    boolean validModuleGrade = false;
    for (int count = 0; count < registrations.size(); count++) {
      if (registrations.get(count).getModule().getCode().equals(gradeToAdd.getModule().getCode())) {
        validModuleGrade = true;
        break;
      } else {
        validModuleGrade = false;
      }
    }

    if (validModuleGrade) {
      Grade grade = new Grade();
      grade.setScore(gradeToAdd.getScore());
      grade.setModule(gradeToAdd.getModule());

      grades.add(grade);
    } else {
      throw new NoRegistrationException(
          "No Registered Module with Code " + gradeToAdd.getModule());
    }


  }

  /**
   * this method gets the grade from its associated module, this module is given in the parameters
   * of the function.
   *
   * @param modulecheck the module that the grade is associated with
   * @return returns the grade associated with the module
   */

  public Grade getGrade(Module modulecheck) throws NoGradeAvailableException {
    Grade returngrade = null;
    for (int count = 0; count < grades.size(); count++) {
      if (grades.get(count).getModule().getCode().equals(modulecheck.getCode())) {
        returngrade = grades.get(count);
        break;
      } else {
        returngrade = null;
      }
    }
    if (returngrade != null) {
      return returngrade;
    } else {
      throw new NoGradeAvailableException(
          "No Grade Available with associated Module " + modulecheck.getCode());
    }
  }

  /**
   * this method computes the average grade out of all the grades for this student.
   *
   * @return this returns the average grade.
   */

  public float computeAverage() throws NoGradeAvailableException {
    float average = 0;
    float averagecount = 0;

    for (int count = 0; count < grades.size(); count++) {
      averagecount += grades.get(count).getScore();
    }
    if (grades.size() != 0) {
      average = averagecount / grades.size();
    } else {
      average = 0;
    }

    return average;

  }



}

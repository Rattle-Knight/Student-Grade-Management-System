package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;

/**
 * this is a class for representing a Student in the grade management program.
 */
public class Student {
  private long id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;

  private List<Grade> grades = new ArrayList<>();

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

  public List<Registration> getRegistrations() {
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
  public void addGrade(Grade gradeToAdd) {
    grades.add(gradeToAdd);
  }

  /**
   * 
   * @param modulecheck
   * @return
   */

  public Grade getGrade(Module modulecheck) {
    Grade returngrade = null;
    for (int count = 0; count < grades.size(); count++) {
      if (grades.get(count).getModuleReference().equals(modulecheck.getCode())) {
        returngrade = grades.get(count);
      }
    }
    return returngrade;
  }



}

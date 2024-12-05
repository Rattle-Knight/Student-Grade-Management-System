package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * this is the class for representing Grades for Modules.
 */
@Entity
public class Grade {

  @Id
  @GeneratedValue
  long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  Student student;

  private Integer score;

  @JoinColumn(name = "module_code")
  private String moduleReference;

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public String getModuleReference() {
    return moduleReference;
  }

  public void setModuleReference(String moduleReference) {
    this.moduleReference = moduleReference;
  }


}

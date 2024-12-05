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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  private Integer score;

  @ManyToOne
  @JoinColumn(name = "module_code")
  Module module;

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public Module getModule() {
    return module;
  }

  public void setModule(Module moduleReference) {
    this.module = moduleReference;
  }


}

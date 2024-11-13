package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * this class models registration within students.
 */
@Entity
public class Registration {

  @Id
  @GeneratedValue
  long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  Student student;

  private String moduleReference;

  public String getModuleReference() {
    return moduleReference;
  }

  public void setModuleReference(String module) {
    this.moduleReference = module;
  }

}

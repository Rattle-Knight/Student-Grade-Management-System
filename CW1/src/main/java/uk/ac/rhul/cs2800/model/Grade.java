package uk.ac.rhul.cs2800.model;

/**
 * this is the class for representing Grades for Modules.
 */
public class Grade {
  private Integer score;
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

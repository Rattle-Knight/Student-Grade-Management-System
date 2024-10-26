package uk.ac.rhul.cs2800.exception;

/**
 * Exception for when there is no grade available for a module.
 */
public class NoGradeAvailableException extends Exception {

  /**
   * custom constructor for the NoGradeAvailableException.
   *
   * @param errorMessage this is the error message parsed for the Exception.
   */
  public NoGradeAvailableException(String errorMessage) {
    super(errorMessage);
  }
}

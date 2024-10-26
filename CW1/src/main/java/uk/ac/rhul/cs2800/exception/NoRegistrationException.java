package uk.ac.rhul.cs2800.exception;

/**
 * Exception for when there is identified access to an unregistered module.
 */
public class NoRegistrationException extends Exception {

  /**
   * custom constructor for the NoRegistrationException.
   *
   * @param errorMessage this is the error message parsed for the Exception.
   */
  public NoRegistrationException(String errorMessage) {
    super(errorMessage);
  }
}

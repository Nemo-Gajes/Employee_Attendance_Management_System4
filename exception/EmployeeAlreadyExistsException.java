package exception;

/**
 * Exception thrown when an employee ID is already registered.
 */
public class EmployeeAlreadyExistsException extends Exception {

  /**
   * Creates an exception with the specified message.
   *
   * @param message the exception message
   */
  public EmployeeAlreadyExistsException(String message) {
    super(message);
  }

}
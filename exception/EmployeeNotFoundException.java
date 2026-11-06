package exception;

/**
 * Exception thrown when an employee ID cannot be found.
 */
public class EmployeeNotFoundException extends Exception {

  /**
   * Creates an exception with the specified message.
   *
   * @param message the exception message
   */
  public EmployeeNotFoundException(String message) {
    super(message);
  }

}
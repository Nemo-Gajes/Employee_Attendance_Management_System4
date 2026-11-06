package exceptions;

/**
 * Exception thrown when an attendance operation violates the rules.
 */
public class InvalidAttendanceException extends Exception {

  /**
   * Creates an exception with the specified message.
   *
   * @param message the exception message
   */
  public InvalidAttendanceException(String message) {
    super(message);
  }

}
import java.time.LocalDateTime;

/**
 * Represents an employee's attendance transaction.
 */
public class AttendanceRecord {

  private String employeeId;
  private LocalDateTime timeIn;
  private LocalDateTime timeOut;

  /**
   * Creates an attendance record with an employee ID and time-in.
   *
   * @param employeeId the employee's ID
   * @param timeIn     the employee's time-in
   */
  public AttendanceRecord(String employeeId, LocalDateTime timeIn) {

    this.employeeId = employeeId;
    this.timeIn = timeIn;
    this.timeOut = null;

  }

  /**
   * Returns the employee ID.
   *
   * @return the employee ID
   */
  public String getEmployeeId() {
    return employeeId;
  }

  /**
   * Returns the time-in value.
   *
   * @return the time-in date and time
   */
  public LocalDateTime getTimeIn() {
    return timeIn;
  }

  /**
   * Returns the time-out value.
   *
   * @return the time-out date and time, or null if not yet completed
   */
  public LocalDateTime getTimeOut() {
    return timeOut;
  }

  /**
   * Updates the time-out value.
   *
   * @param timeOut the employee's time-out
   */
  public void setTimeOut(LocalDateTime timeOut) {
    this.timeOut = timeOut;
  }

}

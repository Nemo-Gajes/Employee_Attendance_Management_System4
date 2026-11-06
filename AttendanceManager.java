import exceptions.EmployeeAlreadyExistsException;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidAttendanceException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages employee registration and attendance records.
 */
public class AttendanceManager {

  private List<Employee> employees;
  private List<AttendanceRecord> attendanceRecords;

  /**
   * Initializes the employee and attendance record collections.
   */
  public AttendanceManager() {

    employees = new ArrayList<>();
    attendanceRecords = new ArrayList<>();

  }

  /**
   * Registers a new employee if their ID does not already exist.
   *
   * @param employee the employee to register
   * @throws EmployeeAlreadyExistsException if the employee ID already exists
   */
  public void registerEmployee(Employee employee)
      throws EmployeeAlreadyExistsException {

    for (Employee emp : employees) {

      if (emp.getEmployeeId().equals(employee.getEmployeeId())) {

        throw new EmployeeAlreadyExistsException(
            "Employee ID already exists.");

      }

    }

    employees.add(employee);

  }

  /**
   * Finds an employee using their employee ID.
   *
   * @param employeeId the ID of the employee to find
   * @return the matching Employee object
   * @throws EmployeeNotFoundException if the employee does not exist
   */
  public Employee findEmployeeById(String employeeId)
      throws EmployeeNotFoundException {

    for (Employee emp : employees) {

      if (emp.getEmployeeId().equals(employeeId)) {

        return emp;

      }

    }

    throw new EmployeeNotFoundException("Employee not found.");

  }

  /**
   * Records an employee's time-in.
   *
   * @param employeeId the ID of the employee
   * @throws EmployeeNotFoundException  if the employee does not exist
   * @throws InvalidAttendanceException if the employee has an active record
   */
  public void timeIn(String employeeId)
      throws EmployeeNotFoundException, InvalidAttendanceException {

    findEmployeeById(employeeId);

    for (AttendanceRecord record : attendanceRecords) {

      if (record.getEmployeeId().equals(employeeId)
          && record.getTimeOut() == null) {

        throw new InvalidAttendanceException(
            "Employee already has an active attendance record.");

      }

    }

    AttendanceRecord newRecord = new AttendanceRecord(employeeId, LocalDateTime.now());

    attendanceRecords.add(newRecord);

  }

  /**
   * Records an employee's time-out.
   *
   * @param employeeId the ID of the employee
   * @throws EmployeeNotFoundException  if the employee does not exist
   * @throws InvalidAttendanceException if no active record exists
   */
  public void timeOut(String employeeId)
      throws EmployeeNotFoundException, InvalidAttendanceException {

    findEmployeeById(employeeId);

    for (AttendanceRecord record : attendanceRecords) {

      if (record.getEmployeeId().equals(employeeId)
          && record.getTimeOut() == null) {

        record.setTimeOut(LocalDateTime.now());

        return;

      }

    }

    throw new InvalidAttendanceException(
        "No active attendance record found.");

  }

  /**
   * Retrieves all completed attendance records for an employee.
   *
   * @param employeeId the ID of the employee
   * @return a List containing the employee's completed attendance records
   * @throws EmployeeNotFoundException if the employee does not exist
   */
  public List<AttendanceRecord> getCompletedAttendanceRecords(String employeeId)
      throws EmployeeNotFoundException {

    findEmployeeById(employeeId);

    List<AttendanceRecord> completedRecords = attendanceRecords.stream()
        .filter(record -> record.getEmployeeId().equals(employeeId)
            && record.getTimeOut() != null)
        .collect(Collectors.toList());

    return completedRecords;

  }

}

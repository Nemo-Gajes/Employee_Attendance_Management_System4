
import exception.EmployeeAlreadyExistsException;
import exception.EmployeeNotFoundException;
import exception.InvalidAttendanceException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Tests the attendance management system.
 *
 * <p>This class tests employee registration, employee searching,
 * time-in and time-out operations, and displaying completed
 * attendance records.
 */
public class Main {

  /**
   * Main method that runs the attendance management test cases.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    AttendanceManager manager = new AttendanceManager();

    // Create employees
    Employee employee1 = new Employee("E001", "Riri Williams", "IT");
    Employee employee2 = new Employee("E002", "Nick Fury", "HR");

    // Test Case 1: Register employees
    System.out.println("=== TEST CASE 1: REGISTER EMPLOYEES ===");

    try {
      manager.registerEmployee(employee1);
      manager.registerEmployee(employee2);

      System.out.println("Employee E001 registered successfully.");
      System.out.println("Employee E002 registered successfully.");

    } catch (EmployeeAlreadyExistsException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 2: Prevent duplicate employee registration
    System.out.println("\n=== TEST CASE 2: DUPLICATE REGISTRATION ===");

    Employee duplicateEmployee = new Employee(
        "E001", "Thor Son of Odin", "Electrical");

    try {
      manager.registerEmployee(duplicateEmployee);

      System.out.println("Employee registered successfully.");

    } catch (EmployeeAlreadyExistsException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 3: Find an existing employee
    System.out.println("\n=== TEST CASE 3: FIND EXISTING EMPLOYEE ===");

    try {
      Employee foundEmployee = manager.findEmployeeById("E001");

      System.out.println("Employee Found:");
      System.out.println("ID: " + foundEmployee.getEmployeeId());
      System.out.println("Name: " + foundEmployee.getName());
      System.out.println("Department: " + foundEmployee.getDepartment());

    } catch (EmployeeNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 4: Handle an unregistered employee
    System.out.println("\n=== TEST CASE 4: FIND UNREGISTERED EMPLOYEE ===");

    try {
      manager.findEmployeeById("E999");

    } catch (EmployeeNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 5: Record an employee's time-in
    System.out.println("\n=== TEST CASE 5: TIME IN ===");

    try {
      manager.timeIn("E001");
      System.out.println("E001 timed in successfully.");

    } catch (EmployeeNotFoundException | InvalidAttendanceException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 6: Prevent multiple active attendance records
    System.out.println("\n=== TEST CASE 6: DUPLICATE TIME IN ===");

    try {
      manager.timeIn("E001");
      System.out.println("E001 timed in successfully.");

    } catch (EmployeeNotFoundException | InvalidAttendanceException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 7: Prevent time-out without an active record
    System.out.println("\n=== TEST CASE 7: INVALID TIME OUT ===");

    try {
      manager.timeOut("E002");
      System.out.println("E002 timed out successfully.");

    } catch (EmployeeNotFoundException | InvalidAttendanceException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 8: Record an employee's time-out
    System.out.println("\n=== TEST CASE 8: TIME OUT ===");

    try {
      manager.timeOut("E001");
      System.out.println("E001 timed out successfully.");

    } catch (EmployeeNotFoundException | InvalidAttendanceException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 9: Allow a new attendance record
    System.out.println("\n=== TEST CASE 9: SECOND ATTENDANCE RECORD ===");

    try {
      manager.timeIn("E001");
      System.out.println("E001 timed in successfully.");

    } catch (EmployeeNotFoundException | InvalidAttendanceException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // Test Case 10: Display completed attendance records
    System.out.println("\n=== TEST CASE 10: COMPLETED ATTENDANCE RECORDS ===");

    try {
      List<AttendanceRecord> records =
          manager.getCompletedAttendanceRecords("E001");

      DateTimeFormatter formatter =
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

      for (AttendanceRecord record : records) {

        System.out.println("Employee ID: " + record.getEmployeeId());

        System.out.println(
            "Time In: " + record.getTimeIn().format(formatter));

        System.out.println(
            "Time Out: " + record.getTimeOut().format(formatter));

        System.out.println("------------------------------");
      }

    } catch (EmployeeNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}

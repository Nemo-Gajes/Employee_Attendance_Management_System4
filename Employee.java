/**
 * Represents an employee in the attendance management system.
 */
public class Employee {

  private String employeeId;
  private String name;
  private String department;

  /**
   * Creates an employee with the specified information.
   *
   * @param employeeId the employee's unique ID
   * @param name       the employee's name
   * @param department the employee's department
   */
  public Employee(String employeeId, String name, String department) {

    this.employeeId = employeeId;
    this.name = name;
    this.department = department;

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
   * Returns the employee's name.
   *
   * @return the employee's name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the employee's department.
   *
   * @return the employee's department
   */
  public String getDepartment() {
    return department;
  }

}
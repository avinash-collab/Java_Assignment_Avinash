import java.util.Objects;

/**
 * Represents an employee with a name and salary.
 */
public class Employee {
    private String employeeName;
    private double salary;

    /**
     * Constructor to initialize an Employee.
     * @param employeeName the name of the employee
     * @param salary the salary of the employee
     */
    public Employee(String employeeName, double salary) {
        this.employeeName = employeeName;
        this.salary = salary;
    }

    // Getter for employee name
    public String getEmployeeName() {
        return employeeName;
    }

    // Getter for employee salary
    public double getSalary() {
        return salary;
    }

    /**
     * Returns a string representation of the Employee.
     */
    @Override
    public String toString() {
        return employeeName + " (Salary: " + salary + ")";
    }

    /**
     * Overrides equals to compare employees based on name and salary.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
               Objects.equals(employeeName, employee.employeeName);
    }

    /**
     * Overrides hashCode to match the equality logic.
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeName, salary);
    }
}

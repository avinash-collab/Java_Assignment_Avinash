/**
 * Represents a department in the organization.
 * Contains the department name.
 */
public class Department {
    private String departmentName;

    /**
     * Constructor to initialize Department with its name.
     * @param departmentName the name of the department
     */
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Getter for department name.
     * @return the name of the department
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Returns the department name as a string.
     * This is useful for printing.
     */
    @Override
    public String toString() {
        return departmentName;
    }
}
 
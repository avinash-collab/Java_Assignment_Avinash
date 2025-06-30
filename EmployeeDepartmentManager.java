import java.util.*;
import java.util.stream.Collectors;

/**
 * This class manages a mapping of Employee to Department.
 * It provides functionality to:
 * 1. List all employees
 * 2. Filter employees based on salary
 * 3. Sort employees by salary
 * 4. Identify the department with the most employees
 */
public class EmployeeDepartmentManager {

    public static void main(String[] args) {
        // Step 1: Create a map of Employee -> Department
        Map<Employee, Department> employeeMap = new HashMap<>();

        // Adding 10 sample employee entries
        employeeMap.put(new Employee("Avinash", 75000), new Department("IT"));
        employeeMap.put(new Employee("Nitesh", 85000), new Department("Finance"));
        employeeMap.put(new Employee("Mohit", 60000), new Department("HR"));
        employeeMap.put(new Employee("Rahul", 95000), new Department("IT"));
        employeeMap.put(new Employee("Sejal", 65000), new Department("Finance"));
        employeeMap.put(new Employee("Deep", 70000), new Department("IT"));
        employeeMap.put(new Employee("Himanshu", 80000), new Department("Marketing"));
        employeeMap.put(new Employee("Alok", 72000), new Department("Finance"));
        employeeMap.put(new Employee("Niraj", 90000), new Department("IT"));
        employeeMap.put(new Employee("Pooja", 68000), new Department("HR"));

        // Step 2: List all employees from the map
        List<Employee> employeeList = getAllEmployees(employeeMap);
        System.out.println("\nAll Employees:");
        employeeList.forEach(emp -> {
            Department dept = employeeMap.get(emp);
            System.out.println(emp + " - Department: " + dept.getDepartmentName());
        });

        // Step 3: Print employees with salary greater than 75000
        System.out.println("\nEmployees with salary > 75000:");
        printEmployeesWithSalaryAbove(employeeList, 75000);

        // Step 4: Sort employees by salary in descending order
        System.out.println("\nEmployees sorted by salary (descending):");
        List<Employee> sorted = sortEmployeesBySalary(employeeList, false);
        sorted.forEach(System.out::println);

        // Step 5: Print the department with the most employees
        System.out.println("\nDepartment with most employees:");
        printDepartmentWithMaxEmployees(employeeMap);
    }

    /**
     * Function 1: Returns a list of all employees from the given map.
     * @param map the employee to department map
     * @return list of employees
     */
    public static List<Employee> getAllEmployees(Map<Employee, Department> map) {
        return new ArrayList<>(map.keySet());
    }

    /**
     * Function 2: Prints employees with salary above the given threshold.
     * @param employees list of employees to check
     * @param salaryThreshold salary to compare against
     */
    public static void printEmployeesWithSalaryAbove(List<Employee> employees, double salaryThreshold) {
        employees.stream()
            .filter(e -> e.getSalary() > salaryThreshold)
            .forEach(System.out::println);
    }

    /**
     * Function 3: Sorts employees by salary.
     * @param employees list of employees to sort
     * @param ascending true for ascending, false for descending
     * @return sorted list of employees
     */
    public static List<Employee> sortEmployeesBySalary(List<Employee> employees, boolean ascending) {
        return employees.stream()
                .sorted((e1, e2) -> ascending ?
                        Double.compare(e1.getSalary(), e2.getSalary()) :
                        Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }

    /**
     * Function 4: Prints the department with the highest number of employees.
     * @param map the employee to department map
     */
    public static void printDepartmentWithMaxEmployees(Map<Employee, Department> map) {
        Map<String, Integer> deptCount = new HashMap<>();

        // Count how many employees belong to each department
        for (Department dept : map.values()) {
            String name = dept.getDepartmentName();
            deptCount.put(name, deptCount.getOrDefault(name, 0) + 1);
        }

        // Find the department with the highest count
        String maxDept = Collections.max(deptCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        int count = deptCount.get(maxDept);

        System.out.println(maxDept + " (" + count + " employees)");
    }
}

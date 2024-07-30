public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    // Constructor
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Main class to manage employee records
    public static class EmployeeManager {
        private Employee[] employees;
        private int size;  // Number of employees currently in the array
        private static final int INITIAL_CAPACITY = 10;  // Initial size of the array

        public EmployeeManager() {
            employees = new Employee[INITIAL_CAPACITY];
            size = 0;
        }

        // Add an employee
        public void addEmployee(int employeeId, String name, String position, double salary) {
            if (size >= employees.length) {
                resizeArray();
            }
            employees[size++] = new Employee(employeeId, name, position, salary);
        }

        // Resize the array to accommodate more employees
        private void resizeArray() {
            int newCapacity = employees.length * 2;
            Employee[] newArray = new Employee[newCapacity];
            System.arraycopy(employees, 0, newArray, 0, employees.length);
            employees = newArray;
        }

        // Search for an employee by ID
        public Employee searchEmployeeById(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == employeeId) {
                    return employees[i];
                }
            }
            return null;
        }

        // Traverse and print all employees
        public void traverseEmployees() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        // Delete an employee by ID
        public boolean deleteEmployeeById(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == employeeId) {
                    // Shift elements to the left
                    System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                    employees[--size] = null;  // Clear the last element
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            // Create an instance of EmployeeManager
            EmployeeManager manager = new EmployeeManager();

            // Adding employees
            manager.addEmployee(1, "Alice", "Manager", 75000);
            manager.addEmployee(2, "Bob", "Developer", 60000);
            manager.addEmployee(3, "Charlie", "Analyst", 50000);

            // Traversing employees
            System.out.println("All Employees:");
            manager.traverseEmployees();

            // Searching for an employee
            System.out.println("\nSearching for employee with ID 2:");
            Employee emp = manager.searchEmployeeById(2);
            System.out.println(emp != null ? emp : "Employee not found");

            // Deleting an employee
            System.out.println("\nDeleting employee with ID 2:");
            boolean isDeleted = manager.deleteEmployeeById(2);
            System.out.println(isDeleted ? "Employee deleted" : "Employee not found");

            // Traversing employees after deletion
            System.out.println("\nAll Employees after deletion:");
            manager.traverseEmployees();
        }
    }
}

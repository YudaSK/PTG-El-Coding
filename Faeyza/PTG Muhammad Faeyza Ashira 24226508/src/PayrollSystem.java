import java.util.ArrayList; // Import ArrayList to store our employees

public class Main {
    public static void main(String[] args) {

        // CHALLENGE REQUIREMENT: Use ArrayList<Employee> to process salaries
        ArrayList<Employee> employeeList = new ArrayList<>();

        // REQUIREMENT: Object Creation
        // Creating specific objects but storing them in the list
        FullTimeEmployee emp1 = new FullTimeEmployee("Ali", "FT001", "Manager", 5000.00);
        PartTimeEmployee emp2 = new PartTimeEmployee("Bob", "PT001", "Clerk", 20.00, 50); // 50 hours
        FullTimeEmployee emp3 = new FullTimeEmployee("Sarah", "FT002", "Developer", 4500.00);

        // Adding them to the list
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        System.out.println("=== PAYROLL SYSTEM REPORT ===");

        // POLYMORPHISM IN ACTION:
        // We loop through the list of 'Employee'. We don't need to know if they are
        // FullTime or PartTime. The code automatically finds the correct calculateSalary() method.
        for (Employee e : employeeList) {
            e.displayInfo(); // From Parent class
            System.out.println("Monthly Salary: $" + e.calculateSalary()); // From Child class (Overridden)
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    public static void main(String[] args) {
        // creating lists
        List<Employee> employeeList = getEmployees();

        System.out.println("=== Payroll Report ===");

        for (Employee emp : employeeList) {

            emp.displayInfo();

            double salary = emp.calculateSalary();

            System.out.println("Calculated Salary: $" + salary);
            System.out.println("-------------------------");
        }
    }

    private static List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        //obj
        FullTimeEmployee ft1 = new FullTimeEmployee("eza", 101, "IT", 5000, 1000, "Premium");
        PartTimeEmployee pt1 = new PartTimeEmployee("adam", 102, "HR", 20, 100, "Morning");
        PartTimeEmployee pt2 = new PartTimeEmployee("yuda", 103, "Marketing", 25, 80, "Night");

        //lists
        employeeList.add(ft1);
        employeeList.add(pt1);
        employeeList.add(pt2);

        return employeeList;
    }
}
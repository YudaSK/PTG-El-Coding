public class FullTimeEmployee extends Employee {

    private double monthlySalary;
    private double bonus;
    private String healthPlan; // Added to ensure we have 3 attributes

    public FullTimeEmployee(String name, int id, String department, double salary, double bonus, String healthPlan) {
        super(name, id, department);
        this.monthlySalary = salary;
        this.bonus = bonus;
        this.healthPlan = healthPlan;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }

    public void displayBenefits() {
        System.out.println("Health Plan: " + healthPlan);
    }
}
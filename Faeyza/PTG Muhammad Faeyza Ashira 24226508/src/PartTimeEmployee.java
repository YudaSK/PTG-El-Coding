public class PartTimeEmployee extends Employee {
    // unique Attributes
    private double hourlyRate;
    private int hoursWorked;
    private String shift;

    public PartTimeEmployee(String name, int id, String department, double rate, int hours, String shift) {
        super(name, id, department);
        this.hourlyRate = rate;
        this.hoursWorked = hours;
        this.shift = shift;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public String getShift() {
        return shift;
    }
}
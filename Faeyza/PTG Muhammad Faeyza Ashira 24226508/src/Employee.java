public abstract class Employee {
    // 3 attributes
    private String name;
    private int id;
    private String department;

    // constructor
    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    // abstract method
    public abstract double calculateSalary();

    // display
    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Dept: " + department);
    }
}
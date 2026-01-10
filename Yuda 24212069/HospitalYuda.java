import java.util.ArrayList;
import java.util.List;

// 1. BASE CLASS (Parent) 
// Represents general human data
class Person {
    // Attributes (Minimal 3 attributes per class) 
    protected String id;
    protected String name;
    protected int age;

    // Constructor 
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Method 1
    public String getName() {
        return name;
    }

    // Method 2: This will be overridden (Polymorphism) 
    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}

// 2. SUBCLASS 1 (Child) 
// Inherits Person, adds Doctor logic
class Doctor extends Person { 
    // Additional attributes
    private String department;
    private String specialization;
    private boolean isAvailable;

    // Constructor
    public Doctor(String id, String name, int age, String department, String specialization) {
        super(id, name, age); // Constructor chaining
        this.department = department;
        this.specialization = specialization;
        this.isAvailable = true; // Default: available
    }

    // Method Overriding 
@Override
    public void displayInfo() {
        String status = isAvailable ? "Available" : "Busy";
        // I UPDATED THE LINE BELOW TO DISPLAY SPECIALIZATION
        System.out.println("[DOCTOR] " + name + " (" + specialization + ") | Dept: " + department + " | Status: " + status);
    }

    // Doctor-specific method
    public boolean checkAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean status) {
        this.isAvailable = status;
    }

    public String getDepartment() {
        return department;
    }
}

// 3. SUBCLASS 2 (Child) 
// Inherits Person, adds Patient logic
class Patient extends Person {
    // Additional attributes
    private String illness;
    private String admissionDate;
    private boolean hasInsurance;

    // Constructor
    public Patient(String id, String name, int age, String illness, String admissionDate) {
        super(id, name, age);
        this.illness = illness;
        this.admissionDate = admissionDate;
        this.hasInsurance = false;
    }

    // Method Overriding 
    @Override
    public void displayInfo() {
        // Insurance status logic
        String insuranceStatus = hasInsurance ? "Insured" : "No Insurance";
        
        // Display ALL data: Name, Illness, Admission Date, and Insurance
        System.out.println("[PATIENT] " + name + 
                           " | Illness: " + illness + 
                           " | Admitted: " + admissionDate + 
                           " | " + insuranceStatus);
    }

    // Patient-specific method
    public String getIllness() {
        return illness;
    }

    public void setInsurance(boolean status) {
        this.hasInsurance = status;
    }
}

// 4. CLASS APPOINTMENT (Aggregation Concept) 
// Links Patient and Doctor
class Appointment {
    private String appointmentID;
    private Doctor doctor; // Aggregation
    private Patient patient; // Aggregation
    private String date;

    public Appointment(String appointmentID, Doctor doctor, Patient patient, String date) {
        this.appointmentID = appointmentID;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public void printAppointmentDetails() {
        System.out.println("\n=== Appointment Receipt ===");
        System.out.println("ID: " + appointmentID);
        System.out.println("Date: " + date);
        System.out.println("Doctor: " + doctor.getName() + " (" + doctor.getDepartment() + ")");
        System.out.println("Patient: " + patient.getName());
        System.out.println("===========================");
    }
}

// 5. MAIN CLASS 
public class HospitalYuda {
    public static void main(String[] args) {
        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM ===\n");

        // 1. Create Array/List of Doctors (Doctor Database)
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("D001", "Dr. Budi", 45, "Cardiology", "Heart Surgeon"));
        doctors.add(new Doctor("D002", "Dr. Siti", 38, "Pediatrics", "Child Care"));
        doctors.add(new Doctor("D003", "Dr. Joko", 50, "General", "General Practitioner"));
        
        // Simulate Dr. Budi is busy
        doctors.get(0).setAvailability(false);

        // 2. Create Patient Objects
        Patient p1 = new Patient("P001", "Andi", 25, "Heart Pain", "2024-01-09");
        Patient p2 = new Patient("P002", "Rina", 8, "Fever", "2024-01-09");

        // Display Info (Polymorphism)
        System.out.println("--- Current Hospital Data ---");
        for (Doctor d : doctors) {
            d.displayInfo();
        }
        p1.displayInfo();
        p2.displayInfo();

        // 3. MAIN LOGIC: Link Patients to Doctors (Challenge) 
        // "Link patients to doctors based on department and availability"
        System.out.println("\n--- Processing Appointments ---");
        
        // Case 1: Andi needs Cardiology
        processAppointment(doctors, p1, "Cardiology");
        
        // Case 2: Rina needs Pediatrics
        processAppointment(doctors, p2, "Pediatrics");
    }

    // Static method for doctor search logic
    public static void processAppointment(List<Doctor> doctorList, Patient patient, String requiredDept) {
        boolean found = false;
        System.out.println("\nLooking for " + requiredDept + " doctor for " + patient.getName() + "...");

        for (Doctor doc : doctorList) {
            // Check if department matches AND doctor is available
            if (doc.getDepartment().equalsIgnoreCase(requiredDept) && doc.checkAvailability()) {
                // Create Appointment
                Appointment appt = new Appointment("APT-" + System.currentTimeMillis(), doc, patient, "2024-01-10");
                appt.printAppointmentDetails();
                
                // Set doctor as busy
                doc.setAvailability(false); 
                found = true;
                break; // Stop searching
            } else if (doc.getDepartment().equalsIgnoreCase(requiredDept) && !doc.checkAvailability()) {
                System.out.println(">> " + doc.getName() + " found but is CURRENTLY BUSY.");
            }
        }

        if (!found) {
            System.out.println(">> FAILED: No available doctor found in " + requiredDept + " department.");
        }
    }
}

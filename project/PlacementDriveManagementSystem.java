import java.util.*;

class Student {
    private int id;
    private String name;
    private String branch;
    private double cgpa;

    public Student(int id, String name, String branch, double cgpa) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("CGPA: " + cgpa);
        System.out.println("---------------------");
    }
}

class Company {
    private int id;
    private String name;
    private String role;
    private double minCgpa;

    public Company(int id, String name, String role, double minCgpa) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.minCgpa = minCgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getMinCgpa() {
        return minCgpa;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Company Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Minimum CGPA: " + minCgpa);
        System.out.println("---------------------");
    }
}

public class PlacementDriveManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Company> companies = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPLACEMENT DRIVE MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Add Company");
            System.out.println("3. View All Students");
            System.out.println("4. View All Companies");
            System.out.println("5. Show Eligible Students for a Company");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCompany();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    viewAllCompanies();
                    break;
                case 5:
                    showEligibleStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(id, name, branch, cgpa));
        System.out.println("Student added successfully!");
    }

    static void addCompany() {
        System.out.print("Enter Company ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Company Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Role: ");
        String role = sc.nextLine();

        System.out.print("Enter Minimum CGPA: ");
        double minCgpa = sc.nextDouble();
        sc.nextLine();

        companies.add(new Company(id, name, role, minCgpa));
        System.out.println("Company added successfully!");
    }

    static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nAll Students:");
        for (Student s : students) {
            s.display();
        }
    }

    static void viewAllCompanies() {
        if (companies.isEmpty()) {
            System.out.println("No companies available.");
            return;
        }

        System.out.println("\nAll Companies:");
        for (Company c : companies) {
            c.display();
        }
    }

    static void showEligibleStudents() {
        System.out.print("Enter Company ID: ");
        int companyId = sc.nextInt();
        sc.nextLine();

        Company company = null;
        for (Company c : companies) {
            if (c.getId() == companyId) {
                company = c;
                break;
            }
        }

        if (company == null) {
            System.out.println("Company not found!");
            return;
        }

        System.out.println("\nEligible Students for " + company.getName() + " - " + company.getRole());
        boolean found = false;

        for (Student s : students) {
            if (s.getCgpa() >= company.getMinCgpa()) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No eligible students found.");
        }
    }
}
import java.util.HashMap;
import java.util.Scanner;

public class StudentRecordManagementSystem {

    public static void main(String[] args) {
        HashMap<Integer, Student> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int nextId = 1;

        System.out.println("Welcome to the Student Record Management System!");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a new Student");
            System.out.println("2. View all Students");
            System.out.println("3. Update a Student's record");
            System.out.println("4. Delete a Student's record");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();

                    studentMap.put(nextId, new Student(nextId, name, marks));
                    System.out.println(" Student added successfully with ID: " + nextId);
                    nextId++;
                    break;

                case 2:
                    System.out.println("\n--- All Student Records ---");
                    if (studentMap.isEmpty()) {
                        System.out.println("No records found. The list is empty.");
                    } else {
                        for (Student student : studentMap.values()) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the ID of the student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    if (studentMap.containsKey(updateId)) {
                        Student studentToUpdate = studentMap.get(updateId);
                        System.out.print("Enter new name for student ID " + updateId + ": ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new marks for student ID " + updateId + ": ");
                        double newMarks = scanner.nextDouble();
                        scanner.nextLine();

                        studentToUpdate.setName(newName);
                        studentToUpdate.setMarks(newMarks);
                        System.out.println(" Student record updated successfully.");
                    } else {
                        System.out.println(" Student with ID " + updateId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    if (studentMap.remove(deleteId) != null) {
                        System.out.println(" Student record deleted successfully.");
                    } else {
                        System.out.println(" Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the system. Goodbye! 👋");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}
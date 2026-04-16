import java.io.*;
import java.util.*;

class Student {
    int id, age;
    String name, grade;

    Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + grade;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Grade: " + grade);
    }
}

class StudentManager {
    private List<Student> studentList = new ArrayList<>();
    private Map<Integer, Student> studentMap = new HashMap<>();
    private String filename = "students.txt";

    public void loadData() {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Student s = new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3]);
                    studentList.add(s);
                    studentMap.put(s.id, s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }

    public void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Student s : studentList) {
                pw.println(s.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public void addStudent(int id, String name, int age, String grade) {
        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }
        Student s = new Student(id, name, age, grade);
        studentList.add(s);
        studentMap.put(id, s);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    public void updateStudent(int id, String name, int age, String grade) {
        Student s = studentMap.get(id);
        if (s != null) {
            s.name = name;
            s.age = age;
            s.grade = grade;
            System.out.println("Record updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        Student s = studentMap.remove(id);
        if (s != null) {
            studentList.remove(s);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(int id) {
        Student s = studentMap.get(id);
        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class StudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadData();

        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println(" 1. Add Student\n 2. View Students\n 3. Update Student\n 4. Delete Student\n 5. Search Student\n 6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: "); String grade = sc.nextLine();
                    manager.addStudent(id, name, age, grade);
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to update: "); int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: "); String uname = sc.nextLine();
                    System.out.print("New Age: "); int uage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Grade: "); String ugrade = sc.nextLine();
                    manager.updateStudent(uid, uname, uage, ugrade);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: "); int did = sc.nextInt();
                    manager.deleteStudent(did);
                    break;
                case 5:
                    System.out.print("Enter ID to search: "); int sid = sc.nextInt();
                    manager.searchStudent(sid);
                    break;
                case 6:
                    manager.saveData();
                    System.out.println("Data saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
        sc.close();
    }
}

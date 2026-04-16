import java.util.Scanner;

class Student {
    int student_id, subjects;
    String name;
    double[] marks;
    
    void Set_Student (int sid, String nm, double[] marks, int subs) {
        this.student_id = sid;
        this.name = nm;
        this.marks = marks;
        this.subjects = subs;
    }
    
    void Display_Studinfo () {
        System.out.println("Following are the student details:");
        System.out.print("\nStudent name: " + name + "\nStudent Id: " + student_id + "\n");
        for (int i=0; i<subjects; i++) {
            System.out.println("Marks for subject " + (i+1) + ": " + marks[i]);
        }
    }
};

class fillInfo {
    public static void main (String[] args) {
        Student S1 = new Student();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter student info:");
        System.out.println("Enter student name: ");
        String Snm = scanner.nextLine();
        System.out.print("Enter student Id number: ");
        int Id = scanner.nextInt();
        System.out.println("How many subjects are there?");
        int sub = scanner.nextInt();
        double[] marks = new double[sub];
        for (int i=0; i<sub; i++) {
            System.out.print("Enter student marks for subject " + (i+1) + ": ");
            marks[i] = scanner.nextDouble();
        }
        /*System.out.print("Enter student marks for subject 1: ");
        marks[0] = scanner.nextDouble();
        System.out.print("Enter student marks for subject 2: ");
        marks[1] = scanner.nextDouble();
        System.out.print("Enter student marks for subject 3: ");
        marks[2] = scanner.nextDouble();*/
        
        S1.Set_Student(Id, Snm, marks, sub);
        S1.Display_Studinfo();
    }
};




package fichario_academico;

import java.util.Scanner;

public class File_student {
    private int MAX_STUDANTS_CAPACITY;
    Student students[] = new Student[MAX_STUDANTS_CAPACITY];
    private Scanner scanner;

    public File_student(Student[] students) {
        this.students = students;
        scanner = new Scanner(System.in);
        MAX_STUDANTS_CAPACITY = students.length;
    }

    public void addStudent(File_class file_class) {
        int i = 0;
        System.out.println("Add student method");

        while (students[i] != null && i < MAX_STUDANTS_CAPACITY - 1) {
            i++;
        }

        if (i < MAX_STUDANTS_CAPACITY) {
            String name, email, ID;
            System.out.println("___ Student Registration ___");
            System.out.println("Input Student Name: ");
            name = scanner.nextLine();
            System.out.println("Input Student Email: ");
            email = scanner.nextLine();
            System.out.println("Input Student ID: ");
            ID = scanner.nextLine();

            int j;
            boolean flag = false;
            for(j = 0; j<MAX_STUDANTS_CAPACITY; j++)    //procura se existe plmns 1 classe
                if(file_class.getClasses()[j] != null){
                    flag = true;
                    break;
                }
            
            if(flag){
                System.out.println("Input Class ID (if student is not matriculate press [ENTER]: ");
                scanner.reset();
                String newClassID;
                newClassID = scanner.nextLine();

            while (newClassID != "" && flag) {
                for (j = 0; j < MAX_STUDANTS_CAPACITY; j++)
                    if (file_class.getClasses()[j] != null)
                        if (newClassID.equals(file_class.getClasses()[j].getClassID())){
                            flag = false;
                            break;
                        }

                if (flag) {
                    System.out.println("Incorrect Class ID, try again or press [ENTER] if student is not matriculate: ");
                    scanner.reset();
                    newClassID = scanner.nextLine();
                }
            }

            Student student = new Student(name, email, ID, newClassID);
            students[i] = student;
            if (newClassID != "") {
                file_class.relacionateStudentClass(students[i], file_class.getClasses()[j]);
            }
            return;
            }

            Student student = new Student(name, email, ID, null);
            students[i] = student;

        } else
            System.out.println("MAXIMUM CAPACITY OF STUDENTS ACHIEVED");
    }

    public void changeStudent() {
        String IDchange;
        boolean flag = false;
        System.out.println("Change student method");
        System.out.println("Inform the ID of a student to change: ");
        IDchange = scanner.nextLine();
        for (int i = 0; i < MAX_STUDANTS_CAPACITY; i++) {
            if (students[i] != null)
                if (IDchange.equals(students[i].getStudentID()) && flag == false) {
                    flag = true;
                    String newName, newEmail, newCPF, newCellphone, newClassID;

                    System.out.println("Inform the name of the student: ");
                    newName = scanner.nextLine();
                    System.out.println("Inform the email of the student: ");
                    newEmail = scanner.nextLine();
                    System.out.println("Inform the CPF of the student: ");
                    newCPF = scanner.nextLine();
                    System.out.println("Inform the cellphone of the student: ");
                    newCellphone = scanner.nextLine();
                    System.out.println("Inform the class ID of the student: ");
                    newClassID = scanner.nextLine();

                    Student newStudent = new Student(newName, newEmail, students[i].studentID, newClassID);
                    newStudent.setCPF(newCPF);
                    newStudent.setCellphone(newCellphone);
                    students[i] = newStudent;
                }
        }
        if (!flag)
            System.out.println("Student ID not found");
    }

    public void removeStudent() {
        System.out.println("Remove student method");
        System.out.println("Inform a student ID to remove: ");
        String IDremove;
        boolean flag = false;
        IDremove = scanner.nextLine();

        for (int i = 0; i < MAX_STUDANTS_CAPACITY; i++)
            if (IDremove.equals(students[i].getStudentID())) {
                students[i] = null;
                flag = true;
            }

        if (!flag)
            System.out.println("Student ID not found");
    }

    public void consultStudent() {
        System.out.println("Search student method");
        System.out.println("1 - Name\n2 - Student ID\n3 - Email");
        int option;
        option = scanner.nextInt();
        if (option > 3 || option < 1)
            option = 2;

        switch (option) {
            case 1:
                searchName();
                break;
            case 2:
                searchID();
                break;
            case 3:
                searchEmail();
                break;
        }
    }

    private void searchName() {
        boolean flag = false;
        System.out.println("Input Student Name: ");
        String name;
        scanner.nextLine();
        scanner.reset();
        name = scanner.nextLine();
        for (int i = 0; i < MAX_STUDANTS_CAPACITY && !flag; i++) 
            if (students[i] != null)
                if (name.equals(students[i].getName())) {
                    System.out.println(students[i]);
                    flag = true;
                }
        
        if (!flag)
            System.out.println("System did not find student " + name);
    }

    private void searchID() {
        boolean flag = false;
        System.out.println("Input Student ID: ");
        String ID;
        scanner.nextLine();
        scanner.reset();
        ID = scanner.nextLine();
        for (int i = 0; i < MAX_STUDANTS_CAPACITY && !flag; i++) {
            if (students[i] != null)
                if (ID.equals(students[i].getStudentID())) {
                    System.out.println(students[i]);
                    flag = true;
                }
        }
        if (!flag)
            System.out.println("System did not find " + ID);
    }

    private void searchEmail() {
        boolean flag = false;
        System.out.println("Input Student Email: ");
        String email;
        scanner.nextLine();
        scanner.reset();
        email = scanner.nextLine();
        for (int i = 0; i < MAX_STUDANTS_CAPACITY && !flag; i++) {
            if (students[i] != null)
                if (email.equals(students[i].getEmail())) {
                    System.out.println(students[i]);
                    flag = true;
                }
        }
        if (!flag)
            System.out.println("System did not find " + email);
    }

    public void reportStatus() {
        System.out.println("Consult all students method");
        System.out.println("------------------------");
        for (int i = 0; i < MAX_STUDANTS_CAPACITY; i++)
            if (students[i] != null)
                System.out.println(students[i] + "\n------------------------");
    }
}

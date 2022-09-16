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
        System.out.println("Add student method\n");
        int j = 0, i = 0;
        boolean flag = false;

        while (students[i] != null && i < MAX_STUDANTS_CAPACITY - 1)
            i++;

        if (i < MAX_STUDANTS_CAPACITY) {
            String name, email, ID;

            System.out.println("___ Student Registration ___");
            System.out.println("Input Student Name: ");
            name = scanner.nextLine();
            System.out.println("Input Student Email: ");
            email = scanner.nextLine();
            System.out.println("Input Student ID: ");
            ID = scanner.nextLine();

            if (file_class.getQTDClasses() > 0) {
                flag = true;
                String newClassID = null;
                System.out.println("Input Class ID (if student is not matriculate press [ENTER]: ");

                while (newClassID != "" && flag) {
                    scanner.reset();
                    newClassID = scanner.nextLine();
                    for (j = 0; j < MAX_STUDANTS_CAPACITY; j++)
                        if (file_class.getClasses()[j] != null)
                            if (newClassID.equals(file_class.getClasses()[j].getClassID())) {
                                flag = false;
                                break;
                            }

                    if (flag)
                        System.out.println(
                                "Incorrect Class ID, try again or press [ENTER] if student is not matriculate: ");
                }

                Student student = new Student(name, email, ID, newClassID);
                students[i] = student;
                System.out.println("Student " + name + " is now registered.");

                if (newClassID != "") {
                    file_class.relacionateStudentClass(students[i], file_class.getClasses()[j]);
                    return;
                }
            }

            Student student = new Student(name, email, ID, null);
            students[i] = student;

        } else
            System.out.println("MAXIMUM CAPACITY OF STUDENTS ACHIEVED");
    }

    public void changeStudent(File_class file_class) {
        System.out.println("Change student method\n");
        String IDchange;
        System.out.println("Inform the ID of a student to change: ");
        IDchange = scanner.nextLine();

        for (int i = 0; i < MAX_STUDANTS_CAPACITY; i++) {
            if (students[i] != null)
                if (IDchange.equals(students[i].getStudentID())) {
                    String newName, newEmail, newCPF, newCellphone, newClassID = "";

                    System.out.println("Inform the name of the student: ");
                    newName = scanner.nextLine();
                    System.out.println("Inform the email of the student: ");
                    newEmail = scanner.nextLine();
                    System.out.println("Inform the CPF of the student: ");
                    newCPF = scanner.nextLine();
                    System.out.println("Inform the cellphone of the student: ");
                    newCellphone = scanner.nextLine();

                    students[i].setName(newName);
                    students[i].setEmail(newEmail);
                    students[i].setCPF(newCPF);
                    students[i].setCellphone(newCellphone);

                    if (file_class.getQTDClasses() > 0) {
                        boolean flag = true;
                        int j = 0;
                        System.out.println("Input Class ID (if student is not matriculate press [ENTER]: ");

                        while (newClassID != "" && flag) {
                            scanner.reset();
                            newClassID = scanner.nextLine();
                            for (j = 0; j < MAX_STUDANTS_CAPACITY; j++)
                                if (file_class.getClasses()[j] != null)
                                    if (newClassID.equals(file_class.getClasses()[j].getClassID())) {
                                        flag = false;
                                        file_class.removeStudentClass(students[i], students[i].getClassID());
                                        break;
                                    }

                            if (flag)   // TODO: problemas aq (mostrando mensagem errada e talvez não associando aluno na classe)
                                System.out.println(
                                        "Incorrect Class ID, try again or press [ENTER] if student is not matriculate: ");
                        }

                        if (newClassID != "") {
                            file_class.relacionateStudentClass(students[i], file_class.getClasses()[j]);
                            students[i].setClassID(newClassID);
                        } else
                            students[i].setClassID(newClassID);
                    }

                    System.out.println("Student " + newName + " was changed.");
                    return;
                }
        }

        System.out.println("Student ID not found");
    }

    public void removeStudent(File_class file_class) {
        System.out.println("Remove student method\n");
        System.out.println("Inform a student ID to remove: ");
        String IDremove;
        IDremove = scanner.nextLine();

        for (int i = 0; i < MAX_STUDANTS_CAPACITY; i++)
            if (students[i] != null)
                if (IDremove.equals(students[i].getStudentID())) {
                    if (students[i].getClassID() != null || students[i].getClassID() != "") {
                        file_class.removeStudentClass(students[i], students[i].getClassID());
                        students[i] = null;
                    }
                    System.out.println("Student " + IDremove + " correctly removed.");
                    return;
                }

        System.out.println("Student ID not found");
    }

    public void consultStudent() {
        System.out.println("Search student method\n");
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
        System.out.println("Consult all students method\n");
        System.out.println("------------------------");
        for (int i = 0; i < MAX_STUDANTS_CAPACITY; i++)
            if (students[i] != null)
                System.out.println(students[i] + "\n------------------------");
    }
}

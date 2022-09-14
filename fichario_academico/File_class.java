package fichario_academico;

import java.util.Scanner;

public class File_class {
    private int MAX_CLASS_CAPACITY;
    private Class classes[] = new Class[MAX_CLASS_CAPACITY];
    private Scanner scanner;

    public File_class(Class classes[]) {
        this.classes = classes;
        scanner = new Scanner(System.in);
        MAX_CLASS_CAPACITY = classes.length;
    }

    public Class[] getClasses() {
        return classes;
    }

    public void addClass(File_professor file_professor) {
        int i = 0;
        String name;
        String ID;
        System.out.println("Add class method");
        while (classes[i] != null && i < MAX_CLASS_CAPACITY - 1)
            i++;

        if (i < MAX_CLASS_CAPACITY) {
            Professor professor = null;
            String associateProfessor;
            Boolean flag = false;

            System.out.println("___ Class Registration ___");
            System.out.println("Input Class Name: ");
            name = scanner.nextLine();
            System.out.println("Input Class ID: ");
            ID = scanner.nextLine();
            for (int j = 0; j < MAX_CLASS_CAPACITY - 1 || flag; j++) // procura se existe agm já professor cadastrado
                if (file_professor.getProfessors()[i] != null) {
                    flag = true;
                    break;
                }
            if (flag) {
                flag = false;
                System.out.println("Input Professor ID (if class does not have a professor yet press [ENTER]: ");
                associateProfessor = scanner.nextLine();
                while (associateProfessor != "" || !flag) {
                    for (int j = 0; j < MAX_CLASS_CAPACITY; j++)
                        if (file_professor.getProfessors()[j] != null)
                            if (associateProfessor.equals(file_professor.getProfessors()[j].getProfessorID())) {
                                flag = true;
                                professor = file_professor.getProfessors()[i];
                            }
                    if (!flag) {
                        System.out.println(
                                "Incorrect Professor ID, try again or press [ENTER] if class does not have a professor yet: ");
                        associateProfessor = scanner.nextLine();
                    }
                }   
            }

            System.out.println("Class created");
            Class newClass = new Class(name, ID, professor);
            classes[i] = newClass;

        } else
            System.out.println("MAXIMUM CAPACITY OF CLASSES ACHIEVED");
    }

    public void removeClass() {
        System.out.println("Remove class method");
        System.out.println("Inform a class ID to remove: ");
        String removeID;
        removeID = scanner.nextLine();
        for (int i = 0; i < MAX_CLASS_CAPACITY; i++) 
            if (classes[i] != null) {
                if (removeID.equals(classes[i].getClassID()) && !securityLock(classes[i])) {
                    System.out.println("Class " + classes[i].getClassID() + " successful removed.");
                    classes[i] = null;
                    return;
                }
            }
            
        
        System.out.println("Class ID not found");
    }

    public boolean securityLock(Class classTest) {
        System.out.println("3");
        System.out.println("-------------" + classTest + "-----------");
        for (int i = 0; i < MAX_CLASS_CAPACITY; i++) {
            if (classTest.getStudents()[i] != null) {
                System.out.println("Class already has students, you can not remove it");
                return true;
            }
        }
        return false;
    }

    public void relacionateStudentClass(Student student, Class class1) {
        int j = 0;

        while (class1.getStudents()[j] != null && j < MAX_CLASS_CAPACITY)
            j++;

        if (j >= MAX_CLASS_CAPACITY) {
            System.out.println("Class already full");
            return;
        }

        System.out.println("Student " + student.getName() + " is now in class " + class1.getClassID());
        class1.setStudent(student, j);
        class1.setQTDStudents(1);
    }

    public void changeClass() {
        String changeClassID;
        boolean flag = false;
        System.out.println("Inform the ID of a class to change: ");
        changeClassID = scanner.nextLine();
        for (int i = 0; i < MAX_CLASS_CAPACITY; i++) {
            if (classes[i] != null) {
                if (changeClassID.equals(classes[i].getClassID()) && !flag) {
                    flag = true;
                    String classID, className;
                    System.out.println("Input new Class ID: ");
                    classID = scanner.nextLine();
                    System.out.println("Input new Class Name: ");
                    className = scanner.nextLine();
                    classes[i].setClassName(className);
                    classes[i].setClassID(classID);

                    for (int j = 0; j < MAX_CLASS_CAPACITY; j++)
                        if (classes[i].getStudents()[j] != null)
                            classes[i].getStudents()[j].setClassID(classID);
                }
            }
        }
        if (!flag)
            System.out.println("Class ID not found");
    }

    public void consultClass() {
        System.out.println("Search class method");
        System.out.println("1 - Name\n2 - Class ID");
        int option;
        option = scanner.nextInt();
        if (option != 1 && option != 2)
            option = 2;

        switch (option) {
            case 1:
                searchName();
                break;
            case 2:
                searchID();
                break;
        }
    }

    private void searchName() {
        boolean flag = false;
        System.out.println("Input Class Name: ");
        String name;
        scanner.nextLine();
        scanner.reset();
        name = scanner.nextLine();
        for (int i = 0; i < MAX_CLASS_CAPACITY && !flag; i++) {
            if (classes[i] != null)
                if (name.equals(classes[i].getClassName())) {
                    System.out.println(classes[i]);
                    flag = true;
                }
        }
        if (!flag)
            System.out.println("System did not find class " + name);
    }

    private void searchID() {
        boolean flag = false;
        System.out.println("Input Class ID: ");
        String ID;
        scanner.nextLine();
        scanner.reset();
        ID = scanner.nextLine();
        for (int i = 0; i < MAX_CLASS_CAPACITY && !flag; i++) {
            if (ID.equals(classes[i].getClassID())) {
                System.out.println(classes[i]);
                flag = true;
            }
        }
        if (!flag)
            System.out.println("System did not find " + ID);
    }

    public void reportStatus() {
        System.out.println("Consult all classes method");
        for (int i = 0; i < MAX_CLASS_CAPACITY; i++)
            if (classes[i] != null)
                System.out.println(classes[i] + "\n------------------------");
    }
}

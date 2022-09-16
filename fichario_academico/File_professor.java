package fichario_academico;

import java.util.Scanner;

public class File_professor {
    private int MAX_PROFESSOR_CAPACITY;
    private Professor professors[] = new Professor[MAX_PROFESSOR_CAPACITY];
    private Scanner scanner;
    private static short qtdProfessor = 0;

    public File_professor(Professor professors[]) {
        this.professors = professors;
        scanner = new Scanner(System.in);
        MAX_PROFESSOR_CAPACITY = professors.length;
    }

    public Professor[] getProfessors() {
        return professors;
    }

    public void setQTDProfessor(int i) {
        qtdProfessor += i;
    }

    public short getQTDProfessor() {
        return qtdProfessor;
    }

    public void addProfessor() {
        System.out.println("Add professor method\n");
        int i = 0;
        String name;
        String email;
        String ID;
        while (professors[i] != null && i < MAX_PROFESSOR_CAPACITY - 1)
            i++;

        if (i < MAX_PROFESSOR_CAPACITY) {
            setQTDProfessor(1);
            System.out.println("___ Professor Registration ___");
            System.out.println("Input Professor Name: ");
            name = scanner.nextLine();
            System.out.println("Input Professor email: ");
            email = scanner.nextLine();
            System.out.println("Input Professor ID: ");
            ID = scanner.nextLine();
            Professor professor = new Professor(name, email, ID);
            professors[i] = professor;
            System.out.println("Professor " + name + "is now registered.");
        } else
            System.out.println("MAXIMUM CAPACITY OF PROFESSORS ACHIEVED");
    }

    public void changeProfessor() {
        System.out.println("Change professor method\n");
        String IDchange;
        boolean flag = false;
        System.out.println("Inform the ID of a professor to change: ");
        IDchange = scanner.nextLine();

        for (int i = 0; i < MAX_PROFESSOR_CAPACITY; i++) {
            if (professors[i] != null)
                if (IDchange.equals(professors[i].getProfessorID()) && !flag) {
                    flag = true;
                    String newName, newEmail, newCPF, newCellphone;

                    System.out.println("Inform the name of the professor: ");
                    newName = scanner.nextLine();
                    System.out.println("Inform the email of the professor: ");
                    newEmail = scanner.nextLine();
                    System.out.println("Inform the CPF of the professor: ");
                    newCPF = scanner.nextLine();
                    System.out.println("Inform the cellphone of the professor: ");
                    newCellphone = scanner.nextLine();

                    Professor newProfessor = new Professor(newName, newEmail, IDchange);
                    newProfessor.setCPF(newCPF);
                    newProfessor.setCellphone(newCellphone);
                    professors[i] = newProfessor;
                }
        }
        if (!flag)
            System.out.println("Professor ID not found");
    }

    public void associateProfessor(File_class file_class) {
        System.out.println("Associate professor to class method\n");
        String ID;
        System.out.println("Inform Professor ID: ");
        ID = scanner.nextLine();

        int i = 0;
        while (i < MAX_PROFESSOR_CAPACITY) {
            if (professors[i] != null)
                if (ID.equals(professors[i].getProfessorID()))
                    break;
            i++;
        }

        if (i >= MAX_PROFESSOR_CAPACITY) {
            System.out.println("Professor ID " + ID + " not found");
            return;
        }

        String classID;
        int cont = 1;
        System.out.printf("Inform %d Class ID to link to a Professor: ", cont);
        classID = scanner.nextLine();
        do {
            boolean flag = false;
            for (int j = 0; j < MAX_PROFESSOR_CAPACITY && !flag; j++) {
                if (classID.equals(file_class.getClasses()[i].getClassID())) {
                    file_class.getClasses()[i].setProfessor(professors[i]);
                    flag = true;
                    cont++;
                }
            }
            if (!flag)
                System.out.println("Wrong Class ID");
            System.out.printf("Inform %d Class ID to link to a Professor or press [ENTER]: ", cont);
            classID = scanner.nextLine();
        } while (classID != "");
    }

    public void removeProfessor() {
        System.out.println("Remove professor method\n");
        System.out.println("Inform a professor ID to remove: ");
        String IDremove;
        boolean flag = false;
        IDremove = scanner.nextLine();

        for (int i = 0; i < MAX_PROFESSOR_CAPACITY && !flag; i++) {
            if (IDremove.equals(professors[i].getProfessorID())) {
                professors[i] = null;
                flag = true;
                setQTDProfessor(-1);
            }
        }
        if (!flag)
            System.out.println("Professor ID " + IDremove + " not found");
    }

    public void consultProfessor() {
        System.out.println("Search professor method\n");
        System.out.println("1 - Name\n2 - Professor ID\n3 - email");
        int option;
        option = scanner.nextInt();
        scanner.nextLine();

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
        System.out.println("Input Professor Name: ");
        String name;
        // scanner.nextLine();
        scanner.reset();
        name = scanner.nextLine();
        for (int i = 0; i < MAX_PROFESSOR_CAPACITY && !flag; i++) {
            if (professors[i] != null)
                if (name.equals(professors[i].getName())) {
                    System.out.println(professors[i]);
                    flag = true;
                }
        }
        if (!flag)
            System.out.println("System did not find professor " + name);
    }

    private void searchID() {
        boolean flag = false;
        System.out.println("Input Professor ID: ");
        String ID;
        // scanner.nextLine();
        scanner.reset();
        ID = scanner.nextLine();
        for (int i = 0; i < MAX_PROFESSOR_CAPACITY && !flag; i++) {
            if (professors[i] != null)
                if (ID.equals(professors[i].getProfessorID())) {
                    System.out.println(professors[i]);
                    flag = true;
                }
        }
        if (!flag)
            System.out.println("System did not find professor" + ID);
    }

    private void searchEmail() {
        boolean flag = false;
        System.out.println("Input Professor Email: ");
        String email;
        // scanner.nextLine();
        scanner.reset();
        email = scanner.nextLine();
        for (int i = 0; i < MAX_PROFESSOR_CAPACITY && !flag; i++) {
            if (professors[i] != null)
                if (email.equals(professors[i].getEmail())) {
                    System.out.println(professors[i]);
                    flag = true;
                }
        }
        if (!flag)
            System.out.println("System did not find professor " + email);
    }

    public void reportStatus() {
        System.out.println("Consult all professors method\n");
        System.out.println("------------------------");
        for (int i = 0; i < MAX_PROFESSOR_CAPACITY; i++)
            if (professors[i] != null)
                System.out.println(professors[i] + "\n------------------------");
    }
}

package fichario_academico;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        // Student aluno = new Student("Arthur", "arthur@aaa", "1234", 4);
        // System.out.println(aluno);
        // Professor professor = new Professor("Josimar", "josimar@aaa", "123");
        // System.out.println(professor);

        // ArrayList<Student> students = new ArrayList();
        // File_student file_student = new File_student();
        // File_professor file_professor = new File_professor();
        // File_class file_class = new File_class();
        Student students[] = new Student[100];
        Professor professors[] = new Professor[100];
        Class classes[] = new Class[100];

        File_student file_student = new File_student(students);
        File_professor file_professor = new File_professor(professors);
        File_class file_class = new File_class(classes);

        Scanner scan = new Scanner(System.in);
        short outside_option, inside_option;

        do {
            System.out.println("\n------------------------");
            System.out.println("____ ACADEMIC MENU ____");
            System.out.println("0 - FINISH PROGRAM");
            System.out.println("1 - STUDENT");
            System.out.println("2 - PROFESSOR");
            System.out.println("3 - CLASS");
            outside_option = scan.nextShort();
            try{

                switch (outside_option) {
                    case 0:
                    System.out.println("------------------------");
                    break;
                    case 1:
                    do {
                        System.out.println("\n------------------------");
                        System.out.println("____ STUDENT MENU ____");
                        System.out.println("0 - GO BACK TO ACADEMIC MENU");
                        System.out.println("1 - ADD STUDENT");
                        System.out.println("2 - CHANGE STUDENT");
                        System.out.println("3 - REMOVE STUDENT");
                        System.out.println("4 - CONSULT STUDENT");
                        System.out.println("5 - CONSULT ALL STUDENTS");
                        inside_option = scan.nextShort();
                        switch (inside_option) {
                            case 0:
                                System.out.println("------------------------");
                                break;
                            case 1:
                            file_student.addStudent(file_class);
                            break;
                            case 2:
                            file_student.changeStudent(file_class);
                            break;
                            case 3:
                                file_student.removeStudent(file_class);
                                break;
                                case 4:
                                file_student.consultStudent();
                                break;
                                case 5:
                                file_student.reportStatus();
                                break;
                                default:
                                System.out.println("Incorrect option");
                                break;
                            }
                        } while (inside_option != 0); // student
                    break;
                case 2:
                    do {
                        System.out.println("\n------------------------");
                        System.out.println("____ PROFESSOR MENU ____");
                        System.out.println("0 - GO BACK TO ACADEMIC MENU");
                        System.out.println("1 - ADD PROFESSOR");
                        System.out.println("2 - CHANGE PROFESSOR");
                        System.out.println("3 - ASSOCIATE PROFESSOR IN A CLASS");
                        System.out.println("4 - DISASSOCIATE PROFESSOR FROM A CLASS");
                        System.out.println("5 - REMOVE PROFESSOR");
                        System.out.println("6 - CONSULT PROFESSOR");
                        System.out.println("7 - CONSULT ALL PROFESSORS");
                        inside_option = scan.nextShort();
                        switch (inside_option) {
                            case 0:
                            System.out.println("------------------------");
                            break;
                            case 1:
                            file_professor.addProfessor();
                            break;
                            case 2:
                            file_professor.changeProfessor();
                            break;
                            case 3:
                            file_professor.associateProfessor(file_class);
                            break;
                            case 4:
                            file_professor.disassociateProfessorClass(file_class);
                            break;
                            case 5:
                            file_professor.removeProfessor(file_class);
                            break;
                            case 6:
                            file_professor.consultProfessor();
                            break;
                            case 7:
                            file_professor.reportStatus();
                            break;
                            default:
                            System.out.println("Incorrect option");
                            break;
                        }
                    } while (inside_option != 0); // professor
                    break;
                    case 3:
                    
                    do {
                        System.out.println("------------------------");
                        System.out.println("____ CLASS MENU ____");
                        System.out.println("0 - GO BACK TO ACADEMIC MENU");
                        System.out.println("1 - ADD CLASS");
                        System.out.println("2 - CHANGE CLASS");
                        System.out.println("3 - REMOVE CLASS");
                        System.out.println("4 - CONSULT CLASS");
                        System.out.println("5 - CONSULT ALL CLASSES");
                        inside_option = scan.nextShort();
                        switch (inside_option) {
                            case 0:
                            System.out.println("------------------------");
                            break;
                            case 1:
                            file_class.addClass(file_professor);
                            break;
                            case 2:
                            file_class.changeClass();
                            break;
                            case 3:
                            file_class.removeClass();
                            break;
                            case 4:
                            file_class.consultClass();
                            break;
                            case 5:
                            file_class.reportStatus();
                            break;
                            default:
                            System.out.println("Incorrect option");
                            break;
                        }
                    } while (inside_option != 0); // class
                    
                    break;
                    default:
                    System.out.println("Incorrect option");
                    break;
                }
            } catch (Exception e) {
                System.out.println("PRESS A CORRECT KEY ");
            }
                
            } while (outside_option != 0); // academic
            System.out.println("End of Program :)");
            scan.close();
        }
    }
    
package fichario_academico;

public class Student extends Person {
    protected String studentID;
    protected String classID; // associado a turmas

    public Student() {
        super(null, null);
    }

    public Student(String name, String email, String studentID, String classID) {
        super(name, email);
        this.studentID = studentID;
        this.classID = classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassID() {
        return classID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nCPF: " + CPF + "\nCellphone: " +
                cellphone + "\nStudent ID: " + studentID + "\nClass ID: " + (classID == "" ? "null" : classID);
    }
}
package fichario_academico;

public class Class {
    private String classID;
    private String className;
    private Student students[] = new Student[100];
    private short qtdStudents = 0;
    private Professor professor;
    // cada turma vai ficar associada a 1 professor

    public Class(String classID, String className, Professor professor) {
        this.classID = classID;
        this.className = className;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudent(Student newStudent, int i) {
        this.students[i] = newStudent;
    }

    public void setQTDStudents(int i) {
        this.qtdStudents += i;
    }

    public short getQTDStudents() {
        return qtdStudents;
    }

    public String toString() {
        return "Class name: " + className + "\nClassID: " + classID + "\nStudents Quantity: " + getQTDStudents()
                + "\nProfessor Name: " + (professor == null ? "null" : professor.getName()) + "\nProfessor ID: " +
                (professor == null ? "null" : professor.getProfessorID());
    }
}

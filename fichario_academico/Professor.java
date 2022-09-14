package fichario_academico;

public class Professor extends Person {
    private String professorID;

    // private String classID;
    Professor() {
        super(null, null);
    }

    Professor(String name, String email, String professorID) {
        super(name, email);
        this.professorID = professorID;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }

    public String toString() {
        return "Name: " + this.name + "\nEmail: " + this.email + "\nCPF: " + this.CPF + "\nCellphone: " +
                this.cellphone + "\nProfessor ID: " + this.professorID;
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


class StudentsSpecialties {

    private String specialtyName;
    private String facultyNumber;

    public StudentsSpecialties(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return this.specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class Student{
    private String studentName;
    private String studentFacultyNumber;

    public Student(String studentName, String studentFacultyNumber) {
        this.studentName = studentName;
        this.studentFacultyNumber = studentFacultyNumber;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentFacultyNumber() {
        return this.studentFacultyNumber;
    }

    public void setStudentFacultyNumber(String studentFacultyNumber) {
        this.studentFacultyNumber = studentFacultyNumber;
    }
}

public class StudentsJoinedToSpecialties {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<StudentsSpecialties> studSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        fillStudentsSpecialties(studSpecialties, scanner);
        fillStudents(students, scanner);

        students.stream().sorted(Comparator.comparing(Student::getStudentName))
                .forEach(st->studSpecialties.stream().filter(studSpec -> st.getStudentFacultyNumber().equalsIgnoreCase(studSpec.getFacultyNumber()))
                        .forEach(res-> System.out.println(st.getStudentName() + " " + res.getFacultyNumber() + " " + res.getSpecialtyName())));
    }

    private static void fillStudentsSpecialties(List<StudentsSpecialties> studSpecialties, Scanner scanner) {
        while(true){
            String[] input = scanner.nextLine().split("\\s+");
            if("Students:".equalsIgnoreCase(input[0])){
                break;
            }
            studSpecialties.add(new StudentsSpecialties(input[0] + " " + input[1], input[2]));
        }
    }

    private static void fillStudents(List<Student> students, Scanner scanner) {
        while(true){
            String[] input = scanner.nextLine().split("\\s+");
            if("END".equalsIgnoreCase(input[0])){
                break;
            }
            students.add(new Student(input[1] + " " + input[2], input[0]));
        }
    }

}

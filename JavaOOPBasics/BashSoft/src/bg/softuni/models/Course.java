package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.NullOrEmptyValueException;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Course {

    public static final int NUMBER_OF_TASK_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public Course(String name, LinkedHashMap<String, Student> studentsByName) {
        this.setName(name);
        this.studentsByName = studentsByName;
    }

    public Course(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<String, Student>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new NullOrEmptyValueException();
        }
        this.name = name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(studentsByName);
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUserName())){
            throw new DuplicateEntryInStructureException( student.getUserName(), this.name);
        }

        this.studentsByName.put(student.getUserName(), student);
    }
}

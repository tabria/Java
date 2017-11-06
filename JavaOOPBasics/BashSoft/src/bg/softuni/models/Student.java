package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.KeyNotFoundException;
import bg.softuni.exceptions.NullOrEmptyValueException;
import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.*;

public class Student {

    private String userName;
    private LinkedHashMap<String, Course>enrolledCourses;
    private LinkedHashMap<String, Double>marksByCourseName;

    public Student(String userName, LinkedHashMap<String, Course> enrolledCourses, LinkedHashMap<String, Double> marksByCourseName) {
        this.setUserName(userName);
        this.enrolledCourses = enrolledCourses;
        this.marksByCourseName = marksByCourseName;
    }

    public Student(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<String, Course>();
        this.marksByCourseName = new LinkedHashMap<String, Double>();
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.equals("")){
            throw new NullOrEmptyValueException();
        }
        this.userName = userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    public void enrollInCourse(Course course){
        if (this.enrolledCourses.containsKey(course.getName())){
            throw new DuplicateEntryInStructureException( this.userName, course.getName());
        }

        this.enrolledCourses.put(course.getName(), course);
    }

    public void setMarksOnCourseName(String courseName, int... scores){
        if (!this.enrolledCourses.containsKey(courseName)){
            throw new KeyNotFoundException();
        }

        if (scores.length > Course.NUMBER_OF_TASK_ON_EXAM) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    public double calculateMark(int[] scores){
        double percentageOfSplvedExam = Arrays.stream(scores).sum() / (double) (Course.NUMBER_OF_TASK_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSplvedExam * 4 + 2;
        return mark;
    }


}

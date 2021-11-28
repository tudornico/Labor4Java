package Uni;

import java.io.Serializable;
import java.util.List;

/**
 * the class for defining what a COURSE is
 */
public class Course implements Serializable {
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private int credits;
    private List<Student> studentsEnrolled;
    private static int counter =0;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @param name the name of the course
     * @param teacher the Teacher which teaches it
     * @param maxEnrollment the maximum number of students that can part-take the course
     * @param credits the amount of credits the course has
     * @param studentsEnrolled the list of students currently tqking the course
     */
    public Course(String name, Person teacher, int maxEnrollment, int credits, List<Student> studentsEnrolled) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.credits = credits;
        this.studentsEnrolled = studentsEnrolled;
        this.ID = ++counter;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void addStudent(Student obj){
        this.studentsEnrolled.add(obj);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", maxEnrollment=" + maxEnrollment +
                ", credits=" + credits +
                ", studentsEnrolled=" + studentsEnrolled +
                '}';
    }
}
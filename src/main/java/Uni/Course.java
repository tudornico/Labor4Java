package Uni;

import java.io.Serializable;
import java.util.List;

/**
 * the class for defining what a COURSE is
 */
public class Course implements Serializable {
    private String name;
    private Teacher teacher;
    private long maxEnrollment;
    private long credits;
    private List<Student> studentsEnrolled;
    private static  long counter =0;
    private long ID;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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
    public Course(String name, Teacher teacher, long maxEnrollment, long credits, List<Student> studentsEnrolled) {
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public long getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(long maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public long getCredits() {
        return credits;
    }

    public void setCredits(long credits) {
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
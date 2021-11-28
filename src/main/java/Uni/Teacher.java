package Uni;



import java.io.Serializable;
import java.util.List;

/**
 * class describing what a teacher is
 */
public class Teacher extends Person implements Serializable {
    private List<Course> courses;
    private static int counter = 0;
    private int ID;

    /**
     * constructor for the class teacher
     * @param courses the list of courses that one teacher teaches
     */
    public Teacher(String firstname,String lastname,List<Course> courses) {
        super(firstname,lastname);
        super.firstname=firstname;
        super.lastname=lastname;
        this.courses = courses;
        this.ID = ++counter;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", courses=" + courses +
                '}';
    }
}

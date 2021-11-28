package Registration;

import Controller.CourseController;
import Controller.StudentController;
import Uni.Course;
import Uni.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    private StudentController studentController;
    private CourseController courseController;

    public RegistrationSystem(StudentController studentController, CourseController courseController) {
        this.studentController = studentController;
        this.courseController = courseController;
    }

    /**
     * Function to register a student to a specific course
     * checking for corner cases such as if the student is already enlisted in the course
     * @param course the course we want to enlist
     * @param student the student that'[s being enlisted
     * @return true if the courses student was added and false otherwise
     */
    public boolean register(Course course, Student student){
        for (Course c:this.courseController.getAll()
             ) {
            if(c.getID() == course.getID())
            {   if(!c.getStudentsEnrolled().contains(student)) {
                c.addStudent(student);
                return true;
            }
            }
        }
        return false;
    }

    /**
     * fucntion that gives back all the courses with free places
     * @return list of courses
     */
    public List<Course> retrieveCoursesWIthFreePlaces(){
        List<Course> reuslt = new ArrayList<>();
        for (Course course:this.courseController.getAll()
             ) {
            if(course.getStudentsEnrolled().size() <=course.getMaxEnrollment())
                reuslt.add(course);
        }
        if(reuslt.isEmpty()){
            System.out.println("All courses are full");
            return null;
        }
        return reuslt;
    }

    /**
     * function that gives back all students enrolled in the given course
     * @param course course we what the students from
     * @return list of students
     */
    public List<Student> retrieveStudentsEnrolledFromACourse(Course course){

        return course.getStudentsEnrolled();
    }

    /**
     * function that gives back all the courses
     * @return list of courses
     */
    public List<Course> getAllCourses(){
        return this.courseController.getAll();
    }

}

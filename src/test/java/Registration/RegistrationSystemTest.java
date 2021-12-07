package Registration;

import Controller.CourseController;
import Controller.StudentController;
import Repo.CourseFileRepository;
import Repo.StudentFileRepository;
import Uni.Course;
import Uni.Student;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class RegistrationSystemTest {

    @org.junit.jupiter.api.Test
    void register() throws IOException, ParseException, ClassNotFoundException {
        Student testStudent = new Student("Ema","Harosa",60,null);
        testStudent.setStudentId(1);
        Course testCourse = new Course("Datenbanken",null,60,6,null);
        testCourse.setID(1);
        //creating list for testing
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        //creating repository for the testing
        StudentFileRepository studentFileRepository = new StudentFileRepository(studentList);
        CourseFileRepository courseFileRepository = new CourseFileRepository(courseList);
        //creating the controllers

        StudentController studentcontroller = new StudentController(studentFileRepository);
        studentcontroller.retrieve();
        CourseController courseController = new CourseController(courseFileRepository);
        courseController.retrieve();
        System.out.println(studentList);
        RegistrationSystem test = new RegistrationSystem(studentcontroller,courseController);
        assert(!test.register(testCourse, testStudent));

    }

    @org.junit.jupiter.api.Test
    void retrieveCoursesWIthFreePlaces() throws IOException, ParseException, ClassNotFoundException {
        Student testStudent = new Student("Tudor","Nicolaescu",60,null);
        testStudent.setStudentId(1);
        Course testCourse = new Course("Datenbanken",null,60,6,null);
        testCourse.setID(1);
        //creating list for testing
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        //creating repository for the testing
        StudentFileRepository studentFileRepository = new StudentFileRepository(studentList);
        CourseFileRepository courseFileRepository = new CourseFileRepository(courseList);
        //creating the controllers

        StudentController studentcontroller = new StudentController(studentFileRepository);
        studentcontroller.retrieve();
        CourseController courseController = new CourseController(courseFileRepository);
        courseController.retrieve();
        RegistrationSystem test = new RegistrationSystem(studentcontroller, courseController);
        System.out.println(studentcontroller.getAll());

    }

    @org.junit.jupiter.api.Test
    void retrieveStudentsEnrolledFromACourse() {
    }

    @org.junit.jupiter.api.Test
    void getAllCourses() throws IOException, ParseException, ClassNotFoundException {
        List<Student> studentList=  new ArrayList<>();
        List<Course> courseList = new ArrayList<>();

        CourseFileRepository courseFileRepository = new CourseFileRepository(courseList);
        StudentFileRepository studentFileRepository = new StudentFileRepository(studentList);
        courseFileRepository.retrieve();
        studentFileRepository.retrieve();
        System.out.println(studentFileRepository.getAll());
    }
}
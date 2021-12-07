package Uni;



import Repo.CourseFileRepository;
import Repo.StudentFileRepository;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {

        //pre processing

        //creating teachers
        Teacher teacher1 = new Teacher("Diana","Cristea",null);
        Teacher teacher2 = new Teacher("Cristian","Sacarea",null);
        //creating teachers list
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        //creating Students
        Student student1 = new Student("Tudor","Nicolaescu",60,null);
        Student student2 = new Student("Francisc","Tulici",60,null);
        Student student3 = new Student("Cristina","Oros",60,null);


        //creating student list
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);


        //creating courses
        Course course1 = new Course("DatenBanken",teacher1,80,6,studentList);
        Course course2 = new Course("Logik",teacher2,60,4,studentList);
        //creaing course list
        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        teacher1.setCourses(courseList);
        teacher2.setCourses(courseList);
        //creating course repository
        CourseFileRepository courseFileRepository=  new CourseFileRepository(courseList);
        courseFileRepository.WriteInFIle();//setting the file

        //getting the students set up with the courses
        student1.setEnrolledCourses(courseList);
        student2.setEnrolledCourses(courseList);
        student3.setEnrolledCourses(courseList);

        //creating student repo
        StudentFileRepository studentFileRepository = new StudentFileRepository(studentList);
        studentFileRepository.WriteInFIle();


    }
}

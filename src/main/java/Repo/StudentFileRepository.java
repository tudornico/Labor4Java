package Repo;

import Uni.Course;
import Uni.IMemoryRepository;
import Uni.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentFileRepository extends IMemoryRepository<Student> implements FileRepo, Serializable {

    private List<Student> studentList;
    //list of ids from a list of courses
    //list of courses from a list of ids

    //first
    List<Integer> IdOfCourses(List<Course> courseList){
        List<Integer> idlist= new ArrayList<>();
        for (Course course: courseList
             ) {
            idlist.add((int) course.getID());
        }
        return idlist;
    }
    //second
    List<Course> CoursesFormID(List<Long> idlist) throws IOException, ParseException, ClassNotFoundException {
        List<Course> inputList= new ArrayList<>();
        CourseFileRepository repository = new CourseFileRepository(inputList);
        //repository.retrieve();
        inputList=repository.getAll();
        List<Course> resultList = new ArrayList<>();
        for (Course course:inputList
             ) {
            if(idlist.contains(course.getID()))
            {
                resultList.add(course);
            }

        }
        return resultList;
    }
    public StudentFileRepository(List<Student> studentList) {
        this.studentList = studentList;
    }
    private JSONObject createJson(Student student){

        JSONObject Jsonresult = new JSONObject();
        Jsonresult.put("First Name : ",student.getFirstname());
        Jsonresult.put("Last Name :",student.getLastname());
        Jsonresult.put("Student Id : ",student.getStudentId());
        Jsonresult.put("Total Credits : ",student.getTotalCredits());
        Jsonresult.put("COurses enrolled : ",IdOfCourses(student.getEnrolledCourses()));
        return Jsonresult;
    }
    @Override
    //ToDO test method
    public void WriteInFIle() throws IOException {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        FileWriter fileWriter =  new FileWriter("StudentFile.json");


        for (Student student:this.studentList
             ) {
            array.add(createJson(student));
        }
        fileWriter.write(array.toJSONString());



        fileWriter.flush();


    }

    @Override
    //TODO Test method
    public void retrieve() throws IOException, ClassNotFoundException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("StudentFile.json");
        Object obj = parser.parse(reader); //jsonarray
        //obj contains the list of json objects idk how to cast to json array
        JSONArray array = new JSONArray();

        array = (JSONArray) obj;
        JSONObject parsingObject = (org.json.simple.JSONObject) array.get(0);
        Student parsingStudent = new Student("","",0,null);
        List<Integer> Idlist = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Course> resultList =  new ArrayList<>(); // all the course will be put into this list


            for(int index= 0;index<array.size();index++) {
                parsingObject= (JSONObject) array.get(index);
                parsingStudent.setFirstname((String) parsingObject.get("First Name : "));
                parsingStudent.setLastname((String) parsingObject.get("Last Name : "));
                parsingStudent.setTotalCredits((Long) parsingObject.get("Total Credits : "));
                parsingStudent.setStudentId((Long) parsingObject.get("Student Id : "));
                //getting from the id's all the courses
                //parsingObject.get("COurse enrolled : ") is a list of id s
                parsingStudent.setEnrolledCourses(CoursesFormID((List<Long>) parsingObject.get("COurses enrolled : ")));
                this.studentList.add(parsingStudent);
            }

    }

    @Override
    /**
     * updates the credit score of a student
     */
    public Student update(Student obj) {
        for (Student student:this.studentList
             ) {
            if(student.getStudentId() == obj.getStudentId()){
                student.setTotalCredits(obj.getTotalCredits());
                return student;
            }
        }

        throw  new IllegalArgumentException("Student not found !!");

    }
}

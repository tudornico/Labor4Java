package Repo;

import Uni.IMemoryRepository;
import Uni.Student;
import org.json.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentFileRepository extends IMemoryRepository<Student> implements FileRepo, Serializable {

    private List<Student> studentList;

    public StudentFileRepository(List<Student> studentList) {
        this.studentList = studentList;
    }
    private JSONObject createJson(Student student){

        JSONObject Jsonresult = new JSONObject();
        Jsonresult.put("First Name : ",student.getFirstname());
        Jsonresult.put("Last Name :",student.getLastname());
        Jsonresult.put("Student Id : ",student.getStudentId());
        Jsonresult.put("Total Credits : ",student.getTotalCredits());
        Jsonresult.put("COurses enrolled : ",student.getEnrolledCourses());
        return Jsonresult;
    }
    @Override
    public void getFromFile() throws IOException {
        JSONArray objectList = new JSONArray();
        
        

        for (Student student:this.studentList
             ) {
            objectList.put(createJson(student));
        }

        FileWriter fileWriter =  new FileWriter("StudentFIle.json");
        fileWriter.write(String.valueOf(objectList));
        fileWriter.flush();
        //TODO manage toJsonString error
    }

    @Override
    //TODO Update the repository file into the studentList
    public void retrieve() throws IOException, ClassNotFoundException {

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

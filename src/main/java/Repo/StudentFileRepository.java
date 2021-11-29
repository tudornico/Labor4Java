package Repo;

import Uni.Course;
import Uni.IMemoryRepository;
import Uni.Student;
import org.json.*;
import org.json.JSONArray;
import org.json.JSONObject;
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
    //ToDO test method
    public void WriteInFIle() throws IOException {
        JSONArray objectList = new JSONArray();
        
        

        for (Student student:this.studentList
             ) {
            objectList.put(createJson(student));
        }

        FileWriter fileWriter =  new FileWriter("StudentFile.json");
        for (Object obj:objectList
             ) {
            fileWriter.write(String.valueOf(obj));
            fileWriter.write('\n');

        }
        fileWriter.flush();


    }

    @Override
    //TODO Test method
    public void retrieve() throws IOException, ClassNotFoundException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("StudentFIle.json");
        Object obj = parser.parse(reader);
        //obj contains the list of json objects idk how to cast to json array
        JSONArray array = new JSONArray();
        array.put(obj);
        System.out.println(array);
        JSONObject parsingObject = new JSONObject();
        Student parsingStudent = new Student("","",0,null);
        for(int index=0;index<array.length();index++){
            parsingObject = array.getJSONObject(index);
            parsingStudent.setFirstname(parsingObject.getString("First Name : "));
            parsingStudent.setLastname(parsingObject.getString("Last Name : "));
            parsingStudent.setTotalCredits(parsingObject.getInt("Total Credits : "));
            parsingStudent.setStudentId(parsingObject.getInt("Id : "));
            parsingStudent.setEnrolledCourses((List<Course>) parsingObject.get("COurses enrolled : "));
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

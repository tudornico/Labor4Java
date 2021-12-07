package Repo;

import Uni.*;
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

public class CourseFileRepository extends IMemoryRepository<Course> implements Serializable,FileRepo  {
    private List<Course> courseList;

    public CourseFileRepository(List<Course> courseList) {
        this.courseList = courseList;
    }

    //id from teacher


    //first from Student to ID
    List<Integer> IDOfStudent(List<Student> studentList){
        List<Integer> idlist = new ArrayList<>();
        for (Student student :studentList
        ) {
            idlist.add((int) student.getStudentId());
        }
        return idlist;
    }

    //from id to courses
    List<Student> StudentsFromID(List<Long> idlist) throws IOException, ParseException, ClassNotFoundException {
        List<Student> inputList = new ArrayList<>();
        StudentFileRepository repository = new StudentFileRepository(inputList);
        repository.retrieve();
        inputList = repository.getAll();
        List<Student> resultList = new ArrayList<>();
        for (Student student:inputList
             ) {
            if(idlist.contains(student.getStudentId())){
                resultList.add(student);
            }
        }
        return resultList;
    }
    private JSONObject createJson(Course course){

        JSONObject Jsonresult = new JSONObject();
        Jsonresult.put("Name : ",course.getName());
        Jsonresult.put("Max Enrolled : ",course.getMaxEnrollment());
        Jsonresult.put("Credits : ",course.getCredits());
        Jsonresult.put("Students enrolled : ",IDOfStudent(course.getStudentsEnrolled()));
        Jsonresult.put("ID : ",course.getID());
        return Jsonresult;
    }
    @Override
    //Todo test method
    public void WriteInFIle() throws IOException {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        FileWriter fileWriter =  new FileWriter("CourseFile.json");


        for (Course course:this.courseList
        ) {
            array.add(createJson(course));
        }
        fileWriter.write(array.toJSONString());



        fileWriter.flush();



    }

    @Override
    //Todo test method
    public void retrieve() throws IOException, ClassNotFoundException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("CourseFile.json");
        Object obj = parser.parse(reader);
        JSONArray array = new JSONArray();
        array = (JSONArray) obj;
        JSONObject parsingObject = new JSONObject();
        Course parsingCourse = new Course("",null,0,0,null);
        for (int i=0;i<array.size();i++){
            parsingObject= (JSONObject) array.get(i);
            //simple parameters
            parsingCourse.setCredits((Long) parsingObject.get("Credits : "));
            parsingCourse.setName((String) parsingObject.get("Name : "));
            parsingCourse.setID((Long) parsingObject.get("ID : "));
            parsingCourse.setMaxEnrollment((Long) parsingObject.get("Max Enrolled : "));

            //id students

            parsingCourse.setStudentsEnrolled(StudentsFromID((List<Long>) parsingObject.get("Students enrolled ; ")));
        }
    }

    @Override
    /**
     * updates the course credit
     */
    public Course update(Course obj) {
        for (Course course:this.repoList
             ) {
            if(course.getID() == obj.getID()){
                course.setCredits(obj.getCredits());
                return course;
            }
        }
        throw new IllegalArgumentException("Course Not Found!!");
    }
}

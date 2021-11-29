package Repo;

import Uni.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class CourseFileRepository extends IMemoryRepository<Course> implements Serializable,FileRepo  {
    private List<Course> courseList;

    public CourseFileRepository(List<Course> courseList) {
        this.courseList = courseList;
    }

    private JSONObject createJson(Course course){

        JSONObject Jsonresult = new JSONObject();
        Jsonresult.put("Name : ",course.getName());
        Jsonresult.put("Teacher :",course.getTeacher());
        Jsonresult.put("Max Enrolled : ",course.getMaxEnrollment());
        Jsonresult.put("Credits : ",course.getCredits());
        Jsonresult.put("Students enrolled : ",course.getStudentsEnrolled());
        Jsonresult.put("ID : ",course.getID());
        return Jsonresult;
    }
    @Override
    //Todo test method
    public void WriteInFIle() throws IOException {
        JSONArray objectList = new JSONArray();



        for (Course course:this.courseList
        ) {
            objectList.put(createJson(course));
        }

        FileWriter fileWriter =  new FileWriter("CourseFile.json");
        for (Object obj:objectList
        ) {
            fileWriter.write(String.valueOf(obj));
            fileWriter.write('\n');

        }
        fileWriter.flush();

    }

    @Override
    //Todo test method
    public void retrieve() throws IOException, ClassNotFoundException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("CourseFile.json");
        Object obj = parser.parse(reader);
        JSONArray array = new JSONArray();
        array.put(obj);
        //System.out.println(array);
        JSONObject parsingObject = new JSONObject();
        Course parsingCourse = new Course("",null,0,0,null);
        for(int index=0;index<array.length();index++){
            parsingObject = array.getJSONObject(index);
            parsingCourse.setName(parsingObject.getString("Name : "));
            parsingCourse.setStudentsEnrolled((List<Student>) parsingObject.get("Students enrolled : "));
            parsingCourse.setTeacher((Teacher) parsingObject.get("Teacher : "));
            parsingCourse.setMaxEnrollment(parsingObject.getInt("Max Enrolled : "));
            parsingCourse.setCredits(parsingObject.getInt("Credits : "));
            parsingCourse.setID(parsingObject.getInt("ID : "));
            this.courseList.add(parsingCourse);
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

package Controller;

import Repo.CourseFileRepository;
import Uni.Course;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class CourseController {
    private CourseFileRepository repr;

    public CourseController(CourseFileRepository repr) {
        this.repr = repr;
    }


    public void getFromFile() throws IOException {
        this.repr.WriteInFIle();
    }

    public void retrieve() throws IOException, ClassNotFoundException, ParseException {
        this.repr.retrieve();
    }

    public Course create(Course obj){
        return this.repr.create(obj);
    }
    public void delete(Course obj){
        this.repr.delete(obj);
    }
    public Course update(Course obj){
        return this.repr.update(obj);
    }
    public List<Course> getAll(){
        return this.repr.getAll();
    }
}
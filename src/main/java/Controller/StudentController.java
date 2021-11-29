package Controller;

import Repo.StudentFileRepository;
import Uni.Student;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class StudentController {

    private StudentFileRepository repr;


    public StudentController(StudentFileRepository repr) {
        this.repr = repr;
    }

    public void getFromFile() throws IOException {
        this.repr.WriteInFIle();
    }

    public void retrieve() throws IOException, ClassNotFoundException, ParseException {
        this.repr.retrieve();
    }

    public Student update(Student obj){
        return this.repr.update(obj);
    }

    public Student create(Student obj){
        return this.repr.create(obj);
    }

    public void delete(Student obj){
         this.repr.delete(obj);
    }

    public List<Student> getAll(){
        return this.repr.getAll();
    }
}
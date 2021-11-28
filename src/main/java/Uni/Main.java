package Uni;



import Repo.StudentFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 =new Student("Tudor","Nicolaescu",60,null);
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        StudentFileRepository repr = new StudentFileRepository(studentList);
        repr.getFromFile();
    }
}

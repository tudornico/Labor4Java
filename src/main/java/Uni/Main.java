package Uni;



import Repo.StudentFileRepository;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {

        StudentFileRepository repository = new StudentFileRepository(null);
        repository.retrieve();
    }
}

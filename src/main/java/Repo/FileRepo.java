package Repo;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileRepo {

    void WriteInFIle() throws IOException;

    void retrieve() throws IOException, ClassNotFoundException, ParseException;
}

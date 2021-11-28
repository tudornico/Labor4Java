package Repo;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileRepo {

    void getFromFile() throws IOException;

    void retrieve() throws IOException, ClassNotFoundException;
}

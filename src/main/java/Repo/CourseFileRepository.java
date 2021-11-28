package Repo;

import Uni.Course;
import Uni.IMemoryRepository;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class CourseFileRepository extends IMemoryRepository<Course> implements Serializable,FileRepo  {
    @Override
    //Todo get data from the json file
    public void getFromFile() throws IOException {

    }

    @Override
    //Todo give back to the json file
    public void retrieve() throws IOException, ClassNotFoundException {

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

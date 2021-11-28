package Controller;

import Repo.CourseRepo;
import Uni.Course;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {

    @org.junit.jupiter.api.Test
    void sortingAfterCredits() {

        Course c1 = new Course("DatenBanken",null,60,5,null);
        Course c2 = new Course("FP",null,70,8,null);
        List<Course> courseList1 = new ArrayList<>();
        List<Course> courseList2 = new ArrayList<>();
        courseList1.add(c1);
        courseList1.add(c2);
        courseList2.add(c2);
        courseList2.add(c1);
        CourseRepo courseRepo = new CourseRepo();
        //courseRepo is like List2
        courseRepo.create(c2);
        courseRepo.create(c1);
        CourseController ctrl = new CourseController(courseRepo);
        assertEquals(ctrl.sortingAfterCredits(),courseList1);
    }

    @org.junit.jupiter.api.Test
    void filterAfterCredits() {
    }
}
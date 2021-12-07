package Repo;

import Uni.IMemoryRepository;
import Uni.Teacher;

import java.util.List;

public class TeacherRepo extends IMemoryRepository<Teacher> {
    private List<Teacher> teacherList;

    public TeacherRepo(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public Teacher update(Teacher obj) {
        return null;
    }
}

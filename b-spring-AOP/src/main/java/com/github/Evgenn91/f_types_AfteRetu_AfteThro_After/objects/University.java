package com.github.Evgenn91.f_types_AfteRetu_AfteThro_After.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        students.add(new Student("xxx",1,0.7));
    }

    public List<Student> getStudents() {
        return students;
    }
}

package com.learn.spring_boot.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.spring_boot.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {
    //    primary key
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Student> students;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

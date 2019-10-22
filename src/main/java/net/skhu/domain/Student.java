package net.skhu.domain;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import net.skhu.board.Homework;
import net.skhu.board.StudentNotice;
import net.skhu.department.Department;
import net.skhu.model.Person;
import net.skhu.relationship.StudentLecture;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {

    @NotNull
    private String studentId;

    private String studentEmail;

    @NotNull
    private String studentName;

    @Digits(integer = 11, fraction = 0)
    private String studentPhone;

    @ManyToOne
    @JoinColumn(name = "department_no")
    private Department department;

    @OneToMany(mappedBy = "student")
    private List<StudentLecture> studentLectureList = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Homework> homeworkList = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<StudentNotice> studentNoticeList = new ArrayList<>();
}

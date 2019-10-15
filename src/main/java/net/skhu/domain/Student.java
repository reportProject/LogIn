package net.skhu.domain;

import javax.persistence.*;

import lombok.Data;
import net.skhu.domain.board.Homework;
import net.skhu.domain.board.StudentNotice;
import net.skhu.domain.department.Department;
import net.skhu.domain.relationship.StudentLecture;
import net.skhu.model.Person;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student extends Person {

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
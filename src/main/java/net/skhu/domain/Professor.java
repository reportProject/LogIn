package net.skhu.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Data;
import net.skhu.board.ProfessorNotice;
import net.skhu.department.Department;
import net.skhu.model.Person;
import net.skhu.relationship.ProfessorLecture;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Professor extends Person {
    @NotNull
    private String professorId;

    private String professorEmail;

    @NotNull
    private String professorName;

    @Digits(integer = 11, fraction = 0)
    private String professorPhone;

    @ManyToOne
    @JoinColumn(name = "department_no")
    private Department department;

    @OneToOne(mappedBy = "professor")
    private Ta ta;

    @OneToMany(mappedBy = "professor")
    private List<ProfessorLecture> professorLectureList = new ArrayList<>();

    @OneToMany(mappedBy = "professor")
    private List<ProfessorNotice> professorNoticeList = new ArrayList<>();

}

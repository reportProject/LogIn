package net.skhu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import net.skhu.domain.board.ProfessorNotice;
import net.skhu.domain.department.Department;
import net.skhu.domain.relationship.ProfessorLecture;
import net.skhu.model.Person;

@Data
@Entity
@Table(name = "professor")
public class Professor extends Person {

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
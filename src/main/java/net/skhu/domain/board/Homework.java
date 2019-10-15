package net.skhu.domain.board;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import net.skhu.domain.Student;
import net.skhu.model.BaseEntity;

@Entity
@Table(name = "homework")
public class Homework extends BaseEntity {

    private String fileName;

    private Integer grade;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate submitDate;

    @ManyToOne
    @JoinColumn(name = "student_no")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "notice_no")
    private ProfessorNotice professorNotice = new ProfessorNotice();

}

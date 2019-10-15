package net.skhu.domain.board;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import net.skhu.domain.Student;
import net.skhu.domain.lecture.Lecture;
import net.skhu.model.BaseBoard;

@Table(name = "student_notice")
@Entity
public class StudentNotice extends BaseBoard {

    private String title;

    @ManyToOne
    @JoinColumn(name = "lecture_no")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "student_no")
    private Student student;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate submitdate;
}
package net.skhu.board;

import org.springframework.format.annotation.DateTimeFormat;

import net.skhu.domain.Professor;
import net.skhu.lecture.Lecture;
import net.skhu.model.BaseBoard;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProfessorNotice extends BaseBoard {

    private String header;

    private String title;

    private Integer perfectScore;

    @JoinColumn(name = "lecture_no")
    private Lecture lecture;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate deadline;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate deadlineAdd;

    @ManyToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "hw_No")
    private Homework homework;

//    @OneToMany(mappedBy = "professor_notice")
//    private List<Comment> commentList = new ArrayList<>();
}

package net.skhu.domain.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import net.skhu.domain.Professor;
import net.skhu.domain.lecture.Lecture;
import net.skhu.model.BaseBoard;

@Entity
@Table(name = "professor_notice")
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

    @OneToMany(mappedBy = "comment")
    private List<Comment> commentList = new ArrayList<>();
}
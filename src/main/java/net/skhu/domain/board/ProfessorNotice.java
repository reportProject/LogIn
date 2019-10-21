package net.skhu.domain.board;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.skhu.domain.Professor;
import net.skhu.domain.lecture.Lecture;
import net.skhu.model.BaseBoard;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "professor_notice")
public class ProfessorNotice extends BaseBoard {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int notice_no;

	@ManyToOne
	@JoinColumn(name = "lecture_no")
	private Lecture lecture;

	@ManyToOne
	@JoinColumn(name = "professor_no")
	private Professor professor;

	private String header;

	private String title;

	private String content;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate submitdate;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate deadline;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate deadline_add;

	private Integer perfect_score;

    @JsonIgnore
    @OneToMany(mappedBy="professorNotice")
    private List<Homework> homework;

	@JsonIgnore
	@OneToMany(mappedBy = "professorNotice")
	private List<Comment> commentList = new ArrayList<>();
}

//package com.report.dbcap.board;
//
//import com.report.dbcap.lecture.Lecture;
//import com.report.dbcap.model.BaseBoard;
//import com.report.dbcap.people.Professor;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class ProfessorNotice extends BaseBoard {
//
//    private String header;
//
//    private String title;
//
//    private Integer perfectScore;
//
//    @JoinColumn(name = "lecture_no")
//    private Lecture lecture;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDate deadline;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDate deadlineAdd;
//
//    @ManyToOne
//    @JoinColumn(name = "professor_no")
//    private Professor professor;
//
//    @ManyToOne
//    @JoinColumn(name = "hw_No")
//    private Homework homework;
//
//    @OneToMany(mappedBy = "comment")
//    private List<Comment> commentList = new ArrayList<>();
//}

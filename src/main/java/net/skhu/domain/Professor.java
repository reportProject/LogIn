package net.skhu.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import net.skhu.domain.board.ProfessorNotice;
import net.skhu.domain.department.Department;
import net.skhu.domain.relationship.ProfessorLecture;
import net.skhu.model.Person;

@Data
@Entity
public class Professor extends Person {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	int professor_no;
	
	String professor_id;
	String professor_name;
	String professor_email;
	String professor_phone;
	String password;
	String password_question;
	String password_answer;
	
    @ManyToOne
    @JoinColumn(name = "department_no")
    private Department department;

    @JsonIgnore
    @OneToOne(mappedBy = "professor")
    private Ta ta;

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<ProfessorLecture> professorLectureList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<ProfessorNotice> professorNoticeList = new ArrayList<>();

}


//package com.report.dbcap.people;
//
//
//import com.report.dbcap.board.ProfessorNotice;
//
//import com.report.dbcap.department.Department;
//import com.report.dbcap.model.Person;
//import com.report.dbcap.relationship.ProfessorLecture;
//
//import javax.persistence.*;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotNull;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Professor extends Person {
//    @NotNull
//    private String professorId;
//
//    private String professorEmail;
//
//    @NotNull
//    private String professorName;
//
//    @Digits(integer = 11, fraction = 0)
//    private String professorPhone;
//
//    @ManyToOne
//    @JoinColumn(name = "department_no")
//    private Department department;
//
//    @OneToOne(mappedBy = "professor")
//    private Ta ta;
//
//    @OneToMany(mappedBy = "professor")
//    private List<ProfessorLecture> professorLectureList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "professor")
//    private List<ProfessorNotice> professorNoticeList = new ArrayList<>();
//
//}

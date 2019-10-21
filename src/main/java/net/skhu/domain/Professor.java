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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.skhu.domain.board.ProfessorNotice;
import net.skhu.domain.department.Department;
import net.skhu.domain.relationship.ProfessorLecture;
import net.skhu.model.Person;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Professor extends Person {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int professor_no;
	
	String professor_id;
	String professor_name;
	String professor_email;
	String professor_phone;
	String password;
	
	@Column(insertable = false, updatable = false)
	String password_question;
	
	@Column(insertable = false, updatable = false)
	String password_answer;
	
    @ManyToOne
    @JoinColumn(name = "department_no")
    private Department department;

    @JsonIgnore
    @OneToOne(mappedBy = "professor")
    private List<Ta> ta;

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<ProfessorLecture> professorLectureList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<ProfessorNotice> professorNoticeList = new ArrayList<>();

}

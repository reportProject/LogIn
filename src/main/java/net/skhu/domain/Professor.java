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

import lombok.Data;
import net.skhu.domain.board.ProfessorNotice;
import net.skhu.domain.department.Department;
import net.skhu.domain.relationship.ProfessorLecture;
import net.skhu.model.Person;

@Data
@Entity
public class Professor extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int professor_no;
	
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

    @OneToOne(mappedBy = "professor")
    private Ta ta;

    @OneToMany(mappedBy = "professor")
    private List<ProfessorLecture> professorLectureList = new ArrayList<>();

    @OneToMany(mappedBy = "professor")
    private List<ProfessorNotice> professorNoticeList = new ArrayList<>();

}
package net.skhu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.skhu.board.Homework;
import net.skhu.board.Student_notice;
import net.skhu.department.Department;
import net.skhu.relationship.Student_lecture;

@Data
@ToString(exclude={"department","student_lectures","student_notices","homeworks"})
@EqualsAndHashCode(exclude={"department","student_lectures","student_notices","homeworks"})
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int student_no;
	
	@Column(name="student_id")
	String studentId;
	String student_name;
	String student_email;
	String student_phone;
	String password;
	String password_question;
	String password_answer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="department_no")
	Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student" , fetch = FetchType.LAZY)
	List<Student_lecture> student_lectures;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student" , fetch = FetchType.LAZY)
	List<Student_notice> student_notices;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	List<Homework> homeworks;
}

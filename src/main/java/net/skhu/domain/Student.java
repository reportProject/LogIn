package net.skhu.domain;

import java.util.List;

import javax.persistence.Entity;
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
	
	String student_id;
	String student_name;
	String student_email;
	String student_phone;
	String password;
	String password_question;
	String password_answer;
	
	@ManyToOne
	@JoinColumn(name="department_no")
	Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	List<Student_lecture> student_lectures;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	List<Student_notice> student_notices;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	List<Homework> homeworks;
}

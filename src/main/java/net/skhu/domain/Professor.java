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
import net.skhu.board.Professor_notice;
import net.skhu.department.Department;
import net.skhu.relationship.Professor_lecture;

@Data
@ToString(exclude={"department","professor_lectures","professor_notices"})
@EqualsAndHashCode(exclude={"department","professor_lectures","professor_notices"})
@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int professor_no;
	
	String professor_id;
	String professor_name;
	String professor_email;
	String professor_phone;
	String password;
	String password_question;
	String password_answer;
	
	@ManyToOne
	@JoinColumn(name="department_no")
	Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	List<Professor_lecture> professor_lectures;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	List<Professor_notice> professor_notices;
	
}

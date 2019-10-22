package net.skhu.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.skhu.domain.board.Homework;
import net.skhu.domain.board.StudentNotice;
import net.skhu.domain.department.Department;
import net.skhu.domain.relationship.StudentLecture;
import net.skhu.model.Person;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Student extends Person {

	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int student_no;
	
	String student_id;
	String student_name;
	String student_email;
	String student_phone;
	String password;
	
	@Column(insertable = false, updatable = false)
	String password_question;
	@Column(insertable = false, updatable = false)
	String password_answer;
	
    @ManyToOne
    @JoinColumn(name = "department_no")
    private Department department;

    @OneToMany(mappedBy = "student")
    private List<StudentLecture> studentLectureList = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Homework> homeworkList = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<StudentNotice> studentNoticeList = new ArrayList<>();
}
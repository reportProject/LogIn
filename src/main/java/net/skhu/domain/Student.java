package net.skhu.domain;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Data;
import net.skhu.board.Homework;
import net.skhu.board.StudentNotice;
import net.skhu.department.Department;
import net.skhu.model.Person;
import net.skhu.relationship.StudentLecture;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student extends Person {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int student_no;
	
	@NotNull
	
    private String student_id;

    private String student_email;

    @NotNull
    private String student_name;

    @Digits(integer = 11, fraction = 0)
    private String studentPhone;

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

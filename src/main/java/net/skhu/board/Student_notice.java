package net.skhu.board;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.skhu.domain.Student;
import net.skhu.lecture.Lecture;

@Data
@ToString(exclude={"lecture","student"})
@EqualsAndHashCode(exclude={"lecture","student"})
@Entity
public class Student_notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int studentnotice_no;
	
	String title;
	Long content;
	Date submitdate;
	
	@ManyToOne
	@JoinColumn(name = "lecture_no")
	Lecture lecture;
	
	@ManyToOne
	@JoinColumn(name = "student_no")
	Student student;
}

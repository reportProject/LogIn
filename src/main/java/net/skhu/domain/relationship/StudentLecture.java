package net.skhu.domain.relationship;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.skhu.domain.Student;


@Entity
public class StudentLecture  {
	@Id
	@JoinColumn(name = "student_no")
    @ManyToOne
    private Student student;
	@EmbeddedId
    private StudentLecturePK studentLecturePK;
}
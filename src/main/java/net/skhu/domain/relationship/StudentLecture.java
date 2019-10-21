package net.skhu.domain.relationship;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import net.skhu.domain.Student;
import net.skhu.domain.lecture.Lecture;

@Entity
public class StudentLecture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne
    @JoinColumn(name = "student_no")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lecture_no")
    private Lecture lecture;
}
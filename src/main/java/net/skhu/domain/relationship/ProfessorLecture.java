package net.skhu.domain.relationship;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.skhu.domain.Professor;
import net.skhu.domain.lecture.Lecture;


public class ProfessorLecture {
	
	@ManyToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;
	
	@ManyToOne
    @JoinColumn(name = "lecture_no")
    private Lecture lecture;
}
package net.skhu.domain.relationship;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import net.skhu.domain.Professor;
import net.skhu.domain.lecture.Lecture;

@Entity
public class ProfessorLecture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "lecture_no")
    private Lecture lecture;
}
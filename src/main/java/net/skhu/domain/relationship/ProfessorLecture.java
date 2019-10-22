package net.skhu.domain.relationship;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.skhu.domain.Professor;


@Entity
public class ProfessorLecture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;
	@EmbeddedId
    private ProfessorLecturePK professorLecturePK;
}
package net.skhu.domain.relationship;

import lombok.Data;
import net.skhu.domain.Professor;
import net.skhu.domain.lecture.Lecture;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class ProfessorLecturePK implements Serializable {
    
	private static final long serialVersionUID = 1L;

//	@ManyToOne
//    @JoinColumn(name = "professor_no")
//    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "lecture_no")
    private Lecture lecture;
}
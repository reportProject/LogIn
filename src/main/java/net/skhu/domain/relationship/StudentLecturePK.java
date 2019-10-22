package net.skhu.domain.relationship;


import lombok.Data;

import net.skhu.domain.Student;
import net.skhu.domain.lecture.Lecture;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class StudentLecturePK implements Serializable {
   
	private static final long serialVersionUID = 1L;

//	@JoinColumn(name = "student_no")
//    @ManyToOne
//    private Student student;

    @JoinColumn(name = "lecture_no")
    @ManyToOne
    private Lecture lecture;
}
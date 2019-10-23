package net.skhu.relationship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.skhu.domain.Professor;
import net.skhu.lecture.Lecture;

@Data
@ToString(exclude={"professor","lecture"})
@EqualsAndHashCode(exclude={"professor","lecture"})
@Entity
public class Professor_lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int professor_lecture_no;
	
	@ManyToOne
	@JoinColumn(name = "professor_no")
	Professor professor;
	
	@ManyToOne
	@JoinColumn(name = "lecture_no")
	Lecture lecture;
}

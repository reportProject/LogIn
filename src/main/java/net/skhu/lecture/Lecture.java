package net.skhu.lecture;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.skhu.board.Professor_notice;
import net.skhu.board.Student_notice;
import net.skhu.domain.Ta;
import net.skhu.relationship.Professor_lecture;
import net.skhu.relationship.Student_lecture;

@Data
@ToString(exclude={"ta","professor_lectures","student_lectures","student_notices","professor_notices"})
@EqualsAndHashCode(exclude={"ta","professor_lectures","student_lectures","student_notices","professor_notices"})
@Entity
public class Lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int lecture_no;
	
	String lecture_name;
	String lecture_type;
	
	@ManyToOne
	@JoinColumn(name = "ta_no")
	Ta ta;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lecture")
	List<Professor_lecture> professor_lectures;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lecture")
	List<Student_lecture> student_lectures;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lecture")
	List<Student_notice> student_notices;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lecture")
	List<Professor_notice> professor_notices;
}

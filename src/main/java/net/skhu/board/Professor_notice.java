package net.skhu.board;

import java.util.Date;
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
import net.skhu.domain.Professor;
import net.skhu.lecture.Lecture;

@Data
@ToString(exclude={"lecture","professor","homeworks"})
@EqualsAndHashCode(exclude={"lecture","professor","homeworks"})
@Entity
public class Professor_notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int notice_no;
	
	String title;
	Long content;
	Date submitdate;
	Date deadline;
	Date deadline_add;
	Integer prefect_score;
	
	@ManyToOne
	@JoinColumn(name = "lecture_no")
	Lecture lecture;
	
	@ManyToOne
	@JoinColumn(name = "professor_no")
	Professor professor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor_notice")
	List<Homework> homeworks;
}

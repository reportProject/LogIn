package net.skhu.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import net.skhu.domain.lecture.Lecture;
import net.skhu.model.BaseEntity;

@Data
@Entity
public class Ta extends BaseEntity {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	int ta_no;
	
	String ta_id;
	
    @OneToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;

    
    private String password;

    @Column(name = "password_question")
    @NotNull
    private String passwordQuestion;

    @Column(name = "password_answer")
    @NotNull
    private String passwordAnswer;

    @OneToMany(mappedBy = "ta")
    private List<Lecture> lectureList= new ArrayList<>();
}
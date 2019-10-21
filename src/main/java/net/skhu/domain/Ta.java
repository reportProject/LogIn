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
import lombok.EqualsAndHashCode;
import net.skhu.domain.lecture.Lecture;
import net.skhu.model.BaseEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Ta extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int ta_no;
	
	String ta_id;
	
    @OneToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;

    
    private String password;

    @Column(insertable = false, updatable = false, name = "password_question")
    @NotNull
    private String passwordQuestion;

    @Column(insertable = false, updatable = false, name = "password_answer")
    @NotNull
    private String passwordAnswer;

    @OneToMany(mappedBy = "ta")
    private List<Lecture> lectureList= new ArrayList<>();
}
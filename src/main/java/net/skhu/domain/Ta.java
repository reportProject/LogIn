package net.skhu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import net.skhu.domain.lecture.Lecture;
import net.skhu.model.BaseEntity;

@Data
@Entity
@Table(name = "ta")
public class Ta extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Column(name = "password")
    @NotNull
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
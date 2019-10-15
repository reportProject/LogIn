package net.skhu.domain.relationship;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.skhu.domain.Professor;
import net.skhu.domain.lecture.Lecture;

@Table(name = "professor_lecture")
public class ProfessorLecture {
    @JoinColumn(name = "professor_no")
    @ManyToOne
    private Professor professor;

    @JoinColumn(name = "lecture_no")
    @ManyToOne
    private Lecture lecture;
}
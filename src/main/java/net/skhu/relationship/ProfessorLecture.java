package net.skhu.relationship;

import lombok.Data;
import net.skhu.domain.Professor;
import net.skhu.lecture.Lecture;
import net.skhu.model.BaseEntity;

import javax.persistence.*;

@Entity
@Data
public class ProfessorLecture extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer StudentLectureNo;

    @ManyToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "lecture_no")
    private Lecture lecture;
}

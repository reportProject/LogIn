package net.skhu.relationship;

import lombok.Data;
import net.skhu.domain.Student;
import net.skhu.lecture.Lecture;

import javax.persistence.*;

@Entity
@Data
public class StudentLecture  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer StudentLectureNo;

    @JoinColumn(name = "student_no")
    @ManyToOne
    private Student student;

    @JoinColumn(name = "lecture_no")
    @ManyToOne
    private Lecture lecture;
}

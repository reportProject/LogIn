package net.skhu.domain.relationship;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.skhu.domain.Student;
import net.skhu.domain.lecture.Lecture;

@Table(name = "student_lecture")
public class StudentLecture {
    @JoinColumn(name = "student_no")
    @ManyToOne
    private Student student;

    @JoinColumn(name = "lecture_no")
    @ManyToOne
    private Lecture lecture;
}
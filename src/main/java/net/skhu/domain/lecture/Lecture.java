package net.skhu.domain.lecture;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.skhu.domain.Professor;
import net.skhu.domain.Ta;
import net.skhu.domain.board.ProfessorNotice;
import net.skhu.domain.board.StudentNotice;
import net.skhu.domain.relationship.ProfessorLecture;
import net.skhu.domain.relationship.StudentLecture;
import net.skhu.model.BaseEntity;

@Entity
@Table(name = "lecture")
public class Lecture extends BaseEntity {

    private String lectureName;

    private String lectureType;

    @OneToMany(mappedBy = "lecture")
    private List<ProfessorLecture> professorLectureList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture")
    private List<StudentLecture> studentLectureList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture")
    private List<StudentNotice> studentNoticeList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture")
    private List<ProfessorNotice> professorNoticeList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ta_no")
    private Ta ta;

}
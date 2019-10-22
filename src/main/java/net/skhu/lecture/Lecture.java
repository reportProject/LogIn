package net.skhu.lecture;

import javax.persistence.*;

import net.skhu.board.ProfessorNotice;
import net.skhu.board.StudentNotice;
import net.skhu.domain.Ta;
import net.skhu.model.BaseEntity;
import net.skhu.relationship.ProfessorLecture;
import net.skhu.relationship.StudentLecture;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lecture extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int lecture_no;
	
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

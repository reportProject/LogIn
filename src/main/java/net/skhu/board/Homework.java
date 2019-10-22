package net.skhu.board;


import org.springframework.format.annotation.DateTimeFormat;

import net.skhu.domain.Student;
import net.skhu.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class Homework extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int hw_no;

    private String fileName;

    private Integer grade;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate submitDate;

    @ManyToOne
    @JoinColumn(name = "student_no")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "notice_no")
    private ProfessorNotice professorNotice;

}

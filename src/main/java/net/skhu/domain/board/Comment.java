package net.skhu.domain.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import net.skhu.model.BaseEntity;

@Entity
public class Comment extends BaseEntity {

    private Integer depth;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate submitDate;

    @ManyToOne
    @JoinColumn(name = "notice_no")
    private ProfessorNotice professorNotice;

//    @OneToMany(mappedBy = "comment")
//    private List<Comment> commentList = new ArrayList<>();
}
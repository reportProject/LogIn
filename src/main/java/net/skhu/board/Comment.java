package net.skhu.board;


import org.springframework.format.annotation.DateTimeFormat;

import net.skhu.model.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int comment_no;
	
    private Integer depth;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate noticeDate;

    @ManyToOne
    @JoinColumn(name = "professor_notice_no")
    private ProfessorNotice professorNotice;

//    @OneToMany(mappedBy = "comment")
//    private List<Comment> commentList = new ArrayList<>();
}

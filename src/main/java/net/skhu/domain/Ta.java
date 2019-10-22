package net.skhu.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import net.skhu.lecture.Lecture;
import net.skhu.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Ta extends BaseEntity {

    @Column(name = "ta_id")
    @NotNull
    private String taId;

    @OneToOne
    @JoinColumn(name = "professor_no")
    private Professor professor;

    @NotNull
    private String password;

    @NotNull
    private String passwordQuestion;

    @NotNull
    private String passwordAnswer;

    @OneToMany(mappedBy = "ta")
    private List<Lecture> lectureList= new ArrayList<>();
}
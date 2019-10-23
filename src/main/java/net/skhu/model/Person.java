package net.skhu.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@MappedSuperclass
public class Person {

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "password_question")
    @NotNull
    private String passwordQuestion;

    @Column(name = "password_answer")
    @NotNull
    private String passwordAnswer;
}

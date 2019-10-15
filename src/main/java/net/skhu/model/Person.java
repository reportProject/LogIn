package net.skhu.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "id")
    @NotNull
    private String id;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "phone")
    @Digits(integer = 11, fraction = 0)
    private String phone;

    @Column(name = "password_question")
    @NotNull
    private String passwordQuestion;

    @Column(name = "password_answer")
    @NotNull
    private String passwordAnswer;
}
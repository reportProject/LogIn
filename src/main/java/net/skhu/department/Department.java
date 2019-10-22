package net.skhu.department;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.skhu.domain.Professor;
import net.skhu.domain.Student;
import net.skhu.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department extends BaseEntity {
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Student> studentList = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Professor> professorList = new ArrayList<>();
}

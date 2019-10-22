package net.skhu.department;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int department_no;
	
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Student> studentList = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Professor> professorList = new ArrayList<>();
}

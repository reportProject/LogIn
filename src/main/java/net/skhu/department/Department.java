package net.skhu.department;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.skhu.domain.Professor;
import net.skhu.domain.Student;

@Data
@ToString(exclude={"professors","students"})
@EqualsAndHashCode(exclude={"professors","students"})
@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int department_no;
	
	String department_name;
	
	@JsonIgnore
	@OneToMany(mappedBy="department")
	List<Professor> professors;

	@JsonIgnore
	@OneToMany(mappedBy="department")
	List<Student> students;
	
}

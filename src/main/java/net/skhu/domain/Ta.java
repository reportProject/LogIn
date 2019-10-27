package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude={"professor"})
@EqualsAndHashCode(exclude={"professor"})
@Entity
public class Ta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ta_no;
	
	@Column(name="ta_id")
	String taId;
	
	String password;
	String password_question;
	String password_answer;
	
	@OneToOne
	@JoinColumn(name="professor_no")
	Professor professor;
}

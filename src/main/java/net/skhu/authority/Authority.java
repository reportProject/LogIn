package net.skhu.authority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int authority_no;
	String student_authority;
	String professor_authority;
	String ta_authority;
	
}

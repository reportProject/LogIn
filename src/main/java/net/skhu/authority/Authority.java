package net.skhu.authority;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import net.skhu.model.BaseEntity;
@Data
@Entity
public class Authority extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int authority_no;
	
    private String student_authority;
    private String professor_authority;
    private String ta_authority;
}
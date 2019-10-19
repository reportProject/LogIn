package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Professor;
import net.skhu.repository.ProfessorRepository;
import net.skhu.utils.EncryptionUtils;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	public Professor login(String professor_id, String password) {
		Professor professor = professorRepository.findOneByProfessor_id(professor_id);
		if (professor == null) {
			return null;
		}
		String pw = EncryptionUtils.encryptMD5(password);
		if (professor.getPassword().equals(pw) == false) {
			return null;
		}
		return professor;
	}
}

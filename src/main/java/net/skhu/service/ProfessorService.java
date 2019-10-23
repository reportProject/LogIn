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

	public Professor login(String professorId, String password) {
		Professor professor = professorRepository.findOneByProfessorId(professorId);
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

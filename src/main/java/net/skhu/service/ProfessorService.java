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
		Professor professor = professorRepository.findByProfessorId(professorId);
		if (professor == null) {
			System.out.println("교수에 입력된 id 값은" + professorId);
			return null;
		}
		String pw = password;
		if (!professor.getPassword().equals(pw)) {
			return null;
		}
		return professor;
	}
}

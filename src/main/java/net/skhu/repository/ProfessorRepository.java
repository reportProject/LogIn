package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.skhu.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	Professor findByProfessorId(String professorId);
}

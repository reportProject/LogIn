package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.skhu.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByStudentId(String studentId);

}

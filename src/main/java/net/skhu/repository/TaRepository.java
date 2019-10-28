package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.skhu.domain.Ta;

@Repository
public interface TaRepository extends JpaRepository<Ta, Integer>{

	Ta findByTaId(String taId);
}

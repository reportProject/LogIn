package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Ta;

public interface TaRepository extends JpaRepository<Ta, Integer>{

	Ta findOneByTaId(String taId);
}

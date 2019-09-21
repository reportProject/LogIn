package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	/*
	 * User 테이블에서 logindId 필드로 레코드를 조회하는 메소드이다.
	 * 
	 * JPA query creation 기능에 의해서, 이 메소드가 자동으로 구현된다
	 * (JPA query creation 강의노트 참고)
	 */
	User findOneByLoginId(String loginId);

}

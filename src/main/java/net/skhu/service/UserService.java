package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.User;
import net.skhu.repository.UserRepository;
import net.skhu.utils.EncryptionUtils;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

	/*
	 * login 메소드
	 * 
	 * 사용자가 입력한 로그인 아이디와 비밀번호를 검사하는 메소드이다.
	 * 
	 * 검사 결과가 성공이면, User 테이블에서 조회한 User 객체를 리턴한다.
	 * 
	 * 검사 결과가 실패면, null을 리턴한다.
	 * 
	 * 사용자가 입력한 비밀번호를 암호화하여 비교하고 있음에 주목
	 */
    public User login(String loginId, String password) {
        User user = userRepository.findOneByLoginId(loginId);
        if (user == null) return null;
        String pw = EncryptionUtils.encryptMD5(password);
        if (user.getPassword().equals(pw) == false) return null;
        return user;
    }
}

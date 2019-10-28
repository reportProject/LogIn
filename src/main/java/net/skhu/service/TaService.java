package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Ta;
import net.skhu.repository.TaRepository;
import net.skhu.utils.EncryptionUtils;

@Service
public class TaService {

	@Autowired
	TaRepository taRepository;

	public Ta login(String taId, String password) {
		Ta ta = taRepository.findByTaId(taId);
		if (ta == null) {
			System.out.println("TA에 입력된 id 값은" + taId);
			return null;
		}
		String pw = password;
		if (!ta.getPassword().equals(pw)) {
			return null;
		}
		return ta;
	}
}

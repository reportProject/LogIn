package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Ta;
import net.skhu.repository.TaRepository;
import net.skhu.utils.EncryptionUtils;

@Service
public class TaService {

	@Autowired TaRepository taRepository;
	
	public Ta login(String ta_id, String password) {
		Ta ta = taRepository.findOneByTa_id(ta_id);
		if(ta == null) {
			return null;
		}
		String pw=EncryptionUtils.encryptMD5(password);
		if(ta.getPassword().equals(pw)==false) {
			return null;
		}
		return ta;
	}
}

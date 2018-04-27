package mx.edu.uacm.concurrencia.service;

import mx.edu.uacm.concurrencia.domain.optimistic.AnotherUserAccount;

public interface AnotherUserAccountService {

	void insertAnotherUserAccount(AnotherUserAccount AnotherUser);

	AnotherUserAccount buscarPorId(Class<AnotherUserAccount> clase, Object o);

}

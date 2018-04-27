package mx.edu.uacm.concurrencia.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import mx.edu.uacm.concurrencia.domain.optimistic.AnotherUserAccount;
import mx.edu.uacm.concurrencia.service.AnotherUserAccountService;

@Service
@Transactional
public class AnotherUserAccountServiceImpl implements AnotherUserAccountService {

	private static final Logger log = LogManager.getLogger(AnotherUserAccountServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertAnotherUserAccount(AnotherUserAccount anotherUser) {
		log.debug("Entrando al metodo AnotherUserAccountServiceImpl.insertAnotherUserAccount");
		em.persist(anotherUser);

	}

	@Override
	public AnotherUserAccount buscarPorId(Class<AnotherUserAccount> clase, Object o) {
		log.debug("Entrando al metodo AnotherUserAccountServiceImpl.buscarPorId");
		return em.find(clase, o);
	}

}

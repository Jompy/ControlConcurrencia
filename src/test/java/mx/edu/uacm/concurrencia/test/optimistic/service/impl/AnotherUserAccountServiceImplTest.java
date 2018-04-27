package mx.edu.uacm.concurrencia.test.optimistic.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.concurrencia.domain.optimistic.AnotherUserAccount;
import mx.edu.uacm.concurrencia.service.AnotherUserAccountService;
import mx.edu.uacm.concurrencia.service.impl.AnotherUserAccountServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HibernateJPA_ControlConcurrencia.class)
public class AnotherUserAccountServiceImplTest {

	private static final Logger log = LogManager.getLogger(AnotherUserAccountServiceImpl.class);

	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private AnotherUserAccountService anotherUserAccountService;

	@Test
	public void testGuardaruserAccountTreads() {
		log.debug("Entrando al metodo AnotherUserAccountServiceImpl.insertAnotherUserAccount");

		AnotherUserAccount anotheruserAccount = new AnotherUserAccount();
		anotheruserAccount.setId(new Long(1));
		anotheruserAccount.setName("Andrea");
		anotheruserAccount.setBalance(600);
		
		taskExecutor.execute(cambioDeSaldoHilo(700,1));

	}

	public Runnable cambioDeSaldoHilo(final double nuevoBalance, final long sleepTime) {
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				log.debug("Run()");
				AnotherUserAccount userAccount = anotherUserAccountService.
						buscarPorId(AnotherUserAccount.class,1);
			}
		});
	}

}

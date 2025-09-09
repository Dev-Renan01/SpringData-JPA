package projeto.spring.data.projeto.spring.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dao.InterfaceSpringDataUser;

@ExtendWith(SpringExtension.class)//Integra os testes JUnit 5 com o Spring
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})// Indica ao Spring qual arquivo XML de configuração carregar
public class SpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testInsert() {
		System.out.println("Iniciou Spring com sucesso");
	}
}

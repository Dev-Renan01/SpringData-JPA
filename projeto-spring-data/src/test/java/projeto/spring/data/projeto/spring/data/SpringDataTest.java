package projeto.spring.data.projeto.spring.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dao.InterfaceSpringDataUser;
import model.UsuarioSpringData;

@ExtendWith(SpringExtension.class) // Integra os testes JUnit 5 com o Spring
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" }) // Indica ao Spring qual arquivo XML de
																				// configuração carregar
public class SpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;

	@Test
	public void testeInsert() {

		UsuarioSpringData usuario = new UsuarioSpringData();

		usuario.setEmail("susu@gmail.com 2");
		usuario.setIdade(20);
		usuario.setLogin("suany 2");
		usuario.setNome("suany 2");
		usuario.setSenha("2222");

		interfaceSpringDataUser.save(usuario);

		System.out.println("Usuário(a) --> " + usuario.getNome() + ", salvo com sucesso!");
		System.out.println("Quantidade de usuários --> " + interfaceSpringDataUser.count());

	}

	@Test
	public void testeConsulta() {

		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(1L);

		System.out.println("Id --> " + usuario.get().getId());
		System.out.println("Nome --> " + usuario.get().getNome());
		System.out.println("E-mail --> " + usuario.get().getEmail());
		System.out.println("Idade --> " + usuario.get().getIdade());
		System.out.println("Login --> " + usuario.get().getLogin());
		System.out.println("Senha --> " + usuario.get().getSenha());

	}

	@Test
	public void testeListarTodos() {

		Iterable<UsuarioSpringData> usuario = interfaceSpringDataUser.findAll();

		for (UsuarioSpringData u : usuario) {
			System.out.println(u);
			System.out.println("------------------------------------------------");

		}
	}

	@Test
	public void testeAtualizar() {

		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(1L);

		UsuarioSpringData data = usuario.get();

		data.setNome("Thiago Renn");

		interfaceSpringDataUser.save(data);

	}

	@Test
	public void testeDeletar() {

		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(52L);

		interfaceSpringDataUser.delete(usuario.get());
	}

	@Test
	public void testeConsultaNome() {

		List<UsuarioSpringData> usuario = interfaceSpringDataUser.buscarPorNome("Thiago");

		for (UsuarioSpringData u : usuario) {
			System.out.println("Consulta por nome --> " + u);
			System.out.println("--------------------------------------------------------");
		}
	}
}

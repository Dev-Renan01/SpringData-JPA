package dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> { 
	
	
	
	
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")// Consulta personalizada que busca usuários pelo nome.
	public List<UsuarioSpringData> buscarPorNome(String nome);
	
	
	@Query(value = "select p from UsuarioSpringData p where p.nome = :nome")// Buscar um único usuário pelo nome exato.
	public UsuarioSpringData buscarPorNomeParam(@Param("nome") String nome);
	
	
	@Modifying // Informa ao Spring Data que essa query não é um SELECT, e sim uma modificação
	@Transactional // Garante que a operação será executada dentro de uma transação
	@Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
	public void deletarPorNome(String nome);
}

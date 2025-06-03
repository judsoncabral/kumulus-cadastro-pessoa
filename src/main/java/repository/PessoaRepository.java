package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Pessoa;

@Repository
public class PessoaRepository {


	@PersistenceContext
	private EntityManager entityManager;

	public List<Pessoa> findAll() {
		return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
	}

	@Transactional
	public void save(Pessoa pessoa) {
		entityManager.persist(pessoa);
		entityManager.flush();
	}
	
	@Transactional
	public void update(Pessoa pessoa) {
		entityManager.merge(pessoa);
		entityManager.flush();
	}

	@Transactional
	public void delete(Long pessoaId) {
		Pessoa endereco = entityManager.find(Pessoa.class, pessoaId);
		if (endereco != null) {
			entityManager.remove(endereco);;
		}
	}

	public Pessoa findById(Long id) {
		 return entityManager.find(Pessoa.class, id);
	}
}

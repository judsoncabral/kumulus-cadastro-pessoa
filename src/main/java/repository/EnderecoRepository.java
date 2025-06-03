package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Endereco;

@Repository
public class EnderecoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Endereco> findAll() {
		return entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
	}

	@Transactional
	public void save(Endereco endereco) {
		entityManager.persist(endereco);
		entityManager.flush();
	}
	
	@Transactional
	public void update(Endereco endereco) {
		entityManager.merge(endereco);
		entityManager.flush();
	}

	@Transactional
	public void delete(Long enderecoId) {
		Endereco endereco = entityManager.find(Endereco.class, enderecoId);
		if (endereco != null) {
			entityManager.remove(endereco);;
		}
	}
}

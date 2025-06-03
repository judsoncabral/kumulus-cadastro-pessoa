package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Endereco;
import repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public void save(Endereco endereco) {
		enderecoRepository.save(endereco);
	}

	public void delete(Long enderecoId) {
		enderecoRepository.delete(enderecoId);
	}

	public void update(Endereco endereco) {
		enderecoRepository.update(endereco);
	}

}

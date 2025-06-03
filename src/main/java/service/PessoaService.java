package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Pessoa;
import repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public void save(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	public void delete(Long pessoaId) {
		pessoaRepository.delete(pessoaId);
	}

	public void update(Pessoa pessoa) {
		pessoaRepository.update(pessoa);
	}

	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id);
	}

}
